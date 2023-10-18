package de.ait.service;

import java.util.List;
import java.util.Set;

public interface GroomingsService {

    Set<String> getTitles();
    String findBread(String bread);
    List<String> gerBreads();
    String findGroomingType(String groom);

}
