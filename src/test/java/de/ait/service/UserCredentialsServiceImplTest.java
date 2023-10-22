package de.ait.service;

import de.ait.models.UserCredential;
import de.ait.repositories.UserCredentialsRepositoryTextFileImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserCredentialsServiceImplTest {
    private UserCredentialsServiceImpl userCredentialsService;

    @BeforeEach
    void setUp() {
        userCredentialsService = new UserCredentialsServiceImpl(
                new UserCredentialsRepositoryTextFileImpl("users_credentialsTest.txt"));
    }
    @Test
    void findAll() {
        List<UserCredential> actual = userCredentialsService.findAll();
        List<UserCredential> expected = new ArrayList<>(List.of(
                new UserCredential("user1","user11"),
                new UserCredential("user2","user22"),
                new UserCredential("user3","user33")
        ));
        assertEquals(expected, actual);
    }

    @Test
    void add() {
        UserCredential userCredential = new UserCredential("user4", "user44");
        userCredentialsService.add(userCredential);
        List<UserCredential> actual = userCredentialsService.findAll();
        assertEquals(4, actual.size());
        removeLastLine("users_credentialsTest.txt");
    }
    public static void removeLastLine(String textFile) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(textFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!lines.isEmpty()) {
            lines.remove(lines.size() - 1);
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter(textFile))) {
            for (String line : lines) {
                writer.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getUserLogin() {
        String actual = userCredentialsService.getUserLogin("user1");
        assertEquals("user1", actual);
    }

    @Test
    void getUserPassword() {
        String expected = userCredentialsService.getUserPassword("user11");
        assertEquals("user11", expected);
    }
}