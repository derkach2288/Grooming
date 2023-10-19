package de.ait.repositories;

import de.ait.models.Grooming;
import de.ait.models.User;

import java.util.List;

public interface GroomingsRepository {
    List<Grooming> findAll();
    void addGrooming(String grooming);
}
