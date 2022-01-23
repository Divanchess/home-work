package com.sbrf.reboot.parallels.utils;

import com.sbrf.reboot.parallels.objects.Account;
import com.sbrf.reboot.parallels.objects.Customer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;


public class MainReportTest {
    public static Stream<Customer> customersStream;

    @BeforeAll
    public static void  createDataAndReturnStream() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(18, "John", Arrays.asList(
                new Account(2029L, 810, LocalDate.now()),
                new Account(90202L, 810, LocalDate.of(2021, 7, 20))
        )));
        customers.add(new Customer(25, "John", Arrays.asList(
                new Account(2L, 810, LocalDate.of(2021, 7, 8)),
                new Account(92L, 978, LocalDate.of(2021, 7, 8))
        )));
        customers.add(new Customer(41, "John", Arrays.asList(
                new Account(1190202L, 840, LocalDate.of(2021, 7, 1))
        )));
        customersStream = customers.stream();
    }

    @Test
    public void getTotalsWithCompletableFuture() throws ExecutionException, InterruptedException {
        Long totalBalance = MainReport.getTotalsWithCompletableFuture(customersStream);
        assertEquals(90204L, totalBalance);
    }

    @Test
    public void getTotalsWithReact() {
        Long totalBalance = MainReport.getTotalsWithReact(customersStream);
        assertEquals(90204L, totalBalance);
    }

}
