package de.ait.repositories;

import de.ait.models.Grooming;
import de.ait.models.User;

import java.util.ArrayList;
import java.util.List;

public class GroomingsRepositoryListImpl implements GroomingsRepository{
    private List<Grooming> groomings = new ArrayList<>(List.of(
            new Grooming("complex", "BEAGLE", "2.0", 50.0),
            new Grooming("hygiene", "YORKSHIRE_TERRIER", "1.5", 60.0),
            new Grooming("hygiene", "PUG", "1.0", 40.0)
    ));
    @Override
    public List<Grooming> findAll() {
        return groomings;
    }
}
