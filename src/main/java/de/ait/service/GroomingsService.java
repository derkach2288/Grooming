package de.ait.service;

import de.ait.dto.GroomingDto;
import de.ait.models.Grooming;

import java.util.List;
import java.util.Set;

public interface GroomingsService {

    Set<String> getTitles();
    String findBread(String bread);
    List<String> getBreads();
    String findGroomingType(String groom);
    List<Grooming> findAll();
    void add(GroomingDto groomingDto);

}
