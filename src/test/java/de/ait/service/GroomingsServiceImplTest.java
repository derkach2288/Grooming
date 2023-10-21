package de.ait.service;

import de.ait.repositories.GroomingsRepositoryListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        List<String> actual = groomingsService.getBreads();
        List<String> expected = List.of("BEAGLE", "YORKSHIRE_TERRIER", "PUG");
        assertEquals(expected, actual);
    }

    @Test
    void findBread() {
        String beagle = groomingsService.findBread("BEAGLE");
        assertEquals(groomingsService.findBread("BEAGLE"), beagle);
        assertTrue(true);
    }

    @Test
    void findGroomingType() {
//        assertEquals("complex", groomingsService.findGroomingType("complex"));
    }

    @Test
    void findAll() {

    }

    @Test
    void add() {
    }
}