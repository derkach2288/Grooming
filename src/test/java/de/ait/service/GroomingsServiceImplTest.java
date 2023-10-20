package de.ait.service;

import de.ait.repositories.GroomingsRepositoryListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GroomingsServiceImplTest {
    private GroomingsServiceImpl groomingsService;

    @BeforeEach
    void setup(){
      groomingsService = new GroomingsServiceImpl(new GroomingsRepositoryListImpl());
    }

    @Test
    void getTitles() {
        Set<String> actual = groomingsService.getTitles();
        Set<String> expected = Set.of("complex", "hygiene");
        assertEquals(expected, actual);
    }

    @Test
    void getBreads() {
    }

    @Test
    void findBread() {
    }

    @Test
    void findGroomingType() {
    }

    @Test
    void findAll() {
    }

    @Test
    void add() {
    }
}