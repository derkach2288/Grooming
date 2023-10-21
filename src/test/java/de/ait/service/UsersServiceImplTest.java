package de.ait.service;

import de.ait.models.User;
import de.ait.repositories.UsersRepositoryTextFileImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsersServiceImplTest {
    private UsersServiceImpl usersService;

    @BeforeEach
    void setUp() {
        usersService = new UsersServiceImpl(new UsersRepositoryTextFileImpl("users.txt"));
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
    }

    @Test
    void add() {
    }
}