package de.ait.service;

import de.ait.dto.UserDto;
import de.ait.models.User;
import de.ait.repositories.UsersRepositoryTextFileImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UsersServiceImplTest {
    private UsersServiceImpl usersService;

    @BeforeEach
    void setUp() {
        usersService = new UsersServiceImpl(new UsersRepositoryTextFileImpl("usersTest.txt"));
    }

    @Test
    void getSecondNames() {
        List<String> actual = usersService.getSecondNames();
        List<String> expected = new ArrayList<>(List.of("Surname1", "Surname2", "Surname3"));
        assertEquals(expected, actual);
    }

    @Test
    void findUserBySecondName() {
        List<String> secondNames = usersService.getSecondNames();
        String actual = "";
        for (String sn: secondNames){
            if (sn.equals("Surname1")){
                actual = sn;
            }
        }
        assertEquals("Surname1", actual);
    }

    @Test
    void findAll() {
        List<User> actual = usersService.findAll();
        List<User> expected = new ArrayList<>(List.of(
                new User("Name1","Surname1","BEAGLE","Sniff","Address 1","name1.name2@gmail.com","11111"),
                new User("Name2","Surname2","GERMAN SHEPHERD","Lord","Address 2","name2.surname2@gmail.com","22222"),
                new User("Name3","Surname3","SAMOYED","Snowy","Address 3","name3.surname3@gmail.com","33333")));

        assertEquals(expected, actual);
    }

    @Test
    void add() {
        UserDto userDto = new UserDto("firstName", "secondName", "breed", "nickname",
                "address", "eMail");
        usersService.add(userDto);
        List<User> actual = usersService.findAll();

        assertEquals(4, actual.size());
        removeLastLine("usersTest.txt");
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

}