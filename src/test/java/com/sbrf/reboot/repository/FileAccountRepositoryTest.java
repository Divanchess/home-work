package com.sbrf.reboot.repository;

import com.sbrf.reboot.entity.Account;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.io.TempDir;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

class FileAccountRepositoryTest {
    @Mock
    FileAccountRepository fileAccountRepository;
    static Map<Account, Long> accountMap;

    @TempDir
    Path tempDir;
    Path testFile;

    @BeforeAll
    public static void createTestData() {
        accountMap = new HashMap<>();
        accountMap.put(new Account("1QWEASD"), 1001L);
        accountMap.put(new Account("2WERSDF"), 2002L);
        accountMap.put(new Account("3ERTDFG"), 3003L);
        accountMap.put(new Account("4RTYFGH"), 2002L);
    }

    @BeforeEach
    void writeTestFile_AndCreateRepositoryInstance() throws IOException {
        assertTrue(Files.isDirectory(tempDir));
        testFile = Files.createFile(tempDir.resolve("accounts.txt"));
        assertTrue(testFile.toFile().exists());

        List<String> linesToWrite = new ArrayList<>();
        for (Map.Entry<Account, Long> entry : accountMap.entrySet()) {
            // File line format : "accountNumber;clientID"
            linesToWrite.add(entry.getKey().getAccountNumber() + ";" + entry.getValue());
        }
        Files.write(testFile, linesToWrite);

        fileAccountRepository = new FileAccountRepository(testFile.toString());
    }

    @Test
    void getAllAccountsByClientIdTest() throws IOException {
        Long expectedClientId = 2002L;
        Set<Account> expectedSet = new HashSet();
        for (Map.Entry<Account, Long> entry : accountMap.entrySet()) {
            if (entry.getValue().equals(expectedClientId)) {
                expectedSet.add(entry.getKey());
            }
        }

        assertTrue(fileAccountRepository.getAllAccountsByClientId(expectedClientId).equals(expectedSet));
    }

    @Test
    void updateAccountNumberInFileTest() throws IOException {
        Long updateClientId = 2002L;
        String accountOld = "2WERSDF";
        String accountNew = "222WERSDF";
        fileAccountRepository.updateAccountNumberInFile(updateClientId, accountOld, accountNew);
        List fileContentList = Files.readAllLines(testFile);
        assertFalse(fileContentList.contains(accountOld + ";" + updateClientId));
        assertTrue(fileContentList.contains(accountNew + ";" + updateClientId));
    }

}
