package de.ait.service;

import de.ait.models.Grooming;
import de.ait.models.User;
import de.ait.repositories.GroomingsRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

public class GroomingsServiceImpl implements GroomingsService {
    GroomingsRepository groomingsRepository;

    public GroomingsServiceImpl(GroomingsRepository groomingsRepository) {
        this.groomingsRepository = groomingsRepository;
    }

    @Override
    public Set<String> getTitles() {
        List<Grooming> groomings = groomingsRepository.findAll();
        return groomings.stream().map(g -> g.getTitle()).collect(Collectors.toSet());
    }

    @Override
    public List<String> gerBreads() {
        List<Grooming> groomings = groomingsRepository.findAll();
        return groomings.stream().map(g -> g.getBreed()).toList();
    }

    @Override
    public String findBread(String bread) {

        List<Grooming> groomings = groomingsRepository.findAll();
        Grooming groming = groomings.stream()
                .filter(grooming -> grooming.getBreed().equals(bread)).findFirst()
                .orElseGet(() -> null);

        if (groming == null){
            return "Такой породы нет";
        } else return groming.toString();
    }

    @Override
    public String findGroomingType(String groom) {
        List<Grooming> groomings = groomingsRepository.findAll();
        Grooming groming = groomings.stream()
                .filter(grooming -> grooming.getTitle().equals(groom)).findFirst()
                .orElseGet(() -> null);

        if (groming == null){
            return "Такой услуги нет";
        } else return groming.getTitle() + ", " +groming.getPeriod();

    }
}
