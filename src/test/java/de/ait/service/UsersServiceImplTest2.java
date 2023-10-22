package de.ait.service;

import de.ait.dto.UserDto;
import de.ait.models.User;
import de.ait.repositories.UserRepositoryListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsersServiceImplTest2 {
    private UsersServiceImpl usersService;

    @BeforeEach
    void setUp() {
        usersService = new UsersServiceImpl(new UserRepositoryListImpl());
    }

    @Test
    void getSecondNames() {
        List<String> actual = usersService.getSecondNames();
        List<String> expected = new ArrayList<>(List.of("Smith", "Russel", "Hoffman"));
        assertEquals(expected, actual);
    }

    @Test
    void findUserBySecondName() {
        List<String> secondNames = usersService.getSecondNames();
        String actual = "";
        for (String sn: secondNames){
            if (sn.equals("Smith")){
                actual = sn;
            }
        }
        assertEquals("Smith", actual);
    }

    @Test
    void findAll() {
        List<User> actual = usersService.findAll();
        List<User> expected = new ArrayList<>(List.of(
                new User("John", "Smith", "PUG", "Dolly"
                        ,"23456, Stuttgart, Hauptstrasse 3", "dolly@gmail.com", "01111"),
                new User("Jack", "Russel", "JACK_RUSSEL", "Jacky",
                        "12345, Berlin, Hauptstrasse 4", "Jacky@gmail.com", "02222"),
                new User("Max", "Hoffman", "SAMOYED", "Gin",
                        "43268, Hamburg, Hauptstrasse 8", "gin@gmail.com", "03333")
        ));
        assertEquals(expected, actual);
    }

    @Test
    void printAllUsers() {
        usersService.printAllUsers();
    }

    @Test
    void add() {
        UserDto userDto = new UserDto("firstName", "secondName", "breed", "nickname",
                "address", "eMail");
        usersService.add(userDto);
        List<User> actual = usersService.findAll();
        assertEquals(4, actual.size());
    }
}