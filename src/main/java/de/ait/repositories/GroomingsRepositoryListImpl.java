package de.ait.repositories;

import de.ait.models.Grooming;
import de.ait.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GroomingsRepositoryListImpl implements GroomingsRepository{
    private List<Grooming> groomings = new ArrayList<>(List.of(
            new Grooming("complex", "BEAGLE", "2.0", 50.0, UUID.randomUUID().toString()),
            new Grooming("hygiene", "YORKSHIRE_TERRIER", "1.5", 60.0, UUID.randomUUID().toString()),
            new Grooming("hygiene", "PUG", "1.0", 40.0, UUID.randomUUID().toString())
    ));
    @Override
    public List<Grooming> findAll() {
        return groomings;
    }

    @Override
    public void addGrooming(String lineGrooming) {
        Grooming newGrooming = parsLine(lineGrooming);
        groomings.add(newGrooming);
    }

//    @Override
//    public void save(Grooming grooming) {
//        groomings.add(grooming);
//    }

    private Grooming parsLine(String lineGrooming) {
        String[] parsed = lineGrooming.split("\\|");
        String title = parsed[0];
        String breeds = parsed[1];
        String period = parsed[2];
        double price = Double.parseDouble(parsed[3]);
        String groomingId = UUID.randomUUID().toString();

        return new Grooming(title, breeds, period, price, groomingId);
    }
}
