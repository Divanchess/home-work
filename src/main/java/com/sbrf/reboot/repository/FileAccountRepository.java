package com.sbrf.reboot.repository;
import com.sbrf.reboot.entity.Account;
import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Класс получения репозитория Accounts из файла
 * Ожидаемый формат строки файла: "accountNumber;clientID"
 */

@RequiredArgsConstructor
public class FileAccountRepository implements AccountRepository {

    @Getter
    @NonNull
    /** Путь до файла */
    private String filePath;

    /**
     * Получение множества Accounts из файла по clientId.
     * @param clientId - Идентификатор клиента
     * @return множество Accounts.
     */
    public Set<Account> getAllAccountsByClientId(long clientId) {
        Set<Account> accounts = new HashSet();
        try {
            InputStream inputStream = new FileInputStream(filePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parsed = line.split(";");
                String parsedAccountNumber = parsed[0];
                Long parsedClientId = new Long(parsed[1]);
                if (parsedClientId == clientId) {
                    accounts.add(new Account(parsedAccountNumber));
                }
            }
            reader.close();
        } catch (Exception E) {
            System.out.println(E);
        }
        return accounts;
    }

    /**
     * Обновление номера счета в файле по идентификатору клиента и номеру счета.
     * @param clientId - Идентификатор клиента
     * @param accountOld - Номер счета, который надо обновить
     * @param accountNew - Новый номер счета для обновления
     * @return множество Accounts.
     */
    public boolean updateAccountNumberInFile(long clientId, String accountOld, String accountNew) {
        String fileContent = "";

        try {
            InputStream inputStream = new FileInputStream(filePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parsed = line.split(";");
                String parsedAccountNumber = parsed[0];
                Long parsedClientId = Long.valueOf(parsed[1]);
                if (parsedClientId == clientId && parsedAccountNumber.equals(accountOld)) {
                    line = line.replaceAll(accountOld, accountNew);
                }
                fileContent += line + "\r\n";
            }
            reader.close();
        } catch (Exception E) {
            System.out.println(E);
            return false;
        }

        try {
            OutputStream outputStream = new FileOutputStream(filePath);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            writer.write(fileContent);
            writer.flush();
            writer.close();
        } catch (Exception E) {
            System.out.println(E);
            return false;
        }

        return true;
    }
}
