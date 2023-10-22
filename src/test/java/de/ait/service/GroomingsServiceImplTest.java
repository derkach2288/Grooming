package de.ait.service;

import de.ait.dto.GroomingDto;
import de.ait.models.Grooming;
import de.ait.repositories.GroomingsRepositoryListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
        String actual = groomingsService.findBread("BEAGLE");
        List<Grooming> groomings = new ArrayList<>(List.of(
                new Grooming("complex", "BEAGLE", "2.0", 50.0, "1111"),
                new Grooming("hygiene", "YORKSHIRE_TERRIER", "1.5", 60.0, "2222"),
                new Grooming("hygiene", "PUG", "1.0", 40.0, "3333")
        ));
        assertEquals(groomings.get(0).toString(), actual);

    }

    @Test
    void findGroomingType() {
        groomingsService.findGroomingType("hygiene");
        List<Grooming> actual = groomingsService.findAll().stream().filter(grooming -> grooming.getTitle().equals("hygiene")).toList();
        List<Grooming> expected = new ArrayList<>(List.of(
                new Grooming("hygiene", "YORKSHIRE_TERRIER", "1.5", 60.0, "2222"),
                new Grooming("hygiene", "PUG", "1.0", 40.0, "3333")
        ));
        assertEquals(expected, actual);

    }

    @Test
    void findAll() {
        List<Grooming> actual = groomingsService.findAll();
        List<Grooming> expected = new ArrayList<>(List.of(
                new Grooming("complex", "BEAGLE", "2.0", 50.0, "1111"),
                new Grooming("hygiene", "YORKSHIRE_TERRIER", "1.5", 60.0, "2222"),
                new Grooming("hygiene", "PUG", "1.0", 40.0, "3333")
        ));
        assertEquals(expected, actual);
    }

    @Test
    void printAllGroomings() {
        groomingsService.printAllGroomings();
    }

    @Test
    void add() {
        groomingsService.add(new GroomingDto("complex", "LABRADOR", "2.0", 70.0));
        assertEquals(4, groomingsService.findAll().stream().count());
    }
}