package de.ait.repositories;

import de.ait.models.Grooming;
import de.ait.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GroomingsRepositoryListImpl implements GroomingsRepository{
    private List<Grooming> groomings = new ArrayList<>(List.of(
            new Grooming("complex", "BEAGLE", "2.0", 50.0, "1111"),
            new Grooming("hygiene", "YORKSHIRE_TERRIER", "1.5", 60.0, "2222"),
            new Grooming("hygiene", "PUG", "1.0", 40.0, "3333")
    ));
    @Override
    public List<Grooming> findAll() {
        return groomings;
    }

    @Override
    public void save(Grooming grooming) {
        groomings.add(grooming);
    }

}
