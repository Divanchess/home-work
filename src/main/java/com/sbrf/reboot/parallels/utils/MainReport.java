package com.sbrf.reboot.parallels.utils;

import com.sbrf.reboot.parallels.objects.Customer;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.time.LocalDate;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class MainReport {

    public static Long getTotalsWithCompletableFuture(Stream<Customer> customersStream) throws ExecutionException, InterruptedException {
        Long sum = 0L;
        Executor executor = Executors.newWorkStealingPool();
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(() -> {
            return getTotalsByParams(customersStream);
        }, executor);

        sum = future.get();
        return sum;
    }

    public static Long getTotalsWithReact(Stream<Customer> customersStream) {
        Scheduler s = Schedulers.parallel();
        final Mono<Long> mono = Mono.just(getTotalsByParams(customersStream));
        mono.subscribeOn(s);
        return mono.block();
    }

    public static Long getTotalsByParams(Stream<Customer> customersStream) {
        // Task params
        LocalDate accountDateFrom = LocalDate.of(2021,7,1);
        LocalDate accountDateTo = LocalDate.of(2021,8,1);
        int accountCurrency = 810;
        int customerAgeFrom = 18;
        int customerAgeTo = 30;

        Long result = customersStream
                .filter(customer -> (customer.getAge() >= customerAgeFrom && customer.getAge() < customerAgeTo))
                .map(customer -> customer.getAccountsBetweenDates(accountDateFrom,accountDateTo)
                        .stream().filter(account -> account.getCurrency() == accountCurrency)
                        .map(account -> account.getBalance()).reduce((x, y) -> x + y))
                .map(x -> x.get()).reduce((x, y) -> x + y).orElse(0L);
        return result;
    }


}
