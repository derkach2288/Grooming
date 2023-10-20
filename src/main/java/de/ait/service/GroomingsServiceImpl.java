package de.ait.service;

import de.ait.dto.GroomingDto;
import de.ait.models.Grooming;
import de.ait.models.User;
import de.ait.repositories.GroomingsRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class GroomingsServiceImpl implements GroomingsService {
    GroomingsRepository groomingsRepository;
    GroomingDto groomingDto;

    public GroomingsServiceImpl(GroomingsRepository groomingsRepository) {
        this.groomingsRepository = groomingsRepository;
    }

    @Override
    public Set<String> getTitles() {
        List<Grooming> groomings = groomingsRepository.findAll();
        return groomings.stream().map(g -> g.getTitle()).collect(Collectors.toSet());
    }

    @Override
    public List<String> getBreads() {
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
    public void findGroomingType(String groom) {
        List<Grooming> groomings = groomingsRepository.findAll();
        groomings.stream()
                .filter(grooming -> grooming.getTitle().equals(groom))
                .forEach(grooming -> System.out.println(grooming));
    }

    @Override
    public List<Grooming> findAll() {
        return groomingsRepository.findAll();
    }

    @Override
    public void printAllGroomings() {
        groomingsRepository.findAll().forEach(grooming -> System.out.println(grooming));
    }

    @Override
    public void add(GroomingDto groomingDto) {

        if (containsThisBreed(groomingDto)){
            System.out.println("ACHTUNG!!! Такая порода уже есть!");
        } else {
            Grooming grooming = new Grooming(groomingDto.getTitle(),
                    groomingDto.getBreed(),
                    groomingDto.getPeriod(),
                    groomingDto.getPrice(),
                    UUID.randomUUID().toString());
            groomingsRepository.save(grooming);
        }
    }

    private boolean containsThisBreed(GroomingDto groomingDto) {
        String newBread = groomingDto.getBreed();
        boolean containsBread = groomingsRepository.findAll().stream()
                .anyMatch(grooming -> grooming.getBreed().equals(newBread));
//        boolean containsBread = groomingsRepository.findAll().stream()
//                .anyMatch(grooming -> {
//                    return grooming.getBreed().equals(newBread) && grooming.getTitle().equals(groomingDto.getTitle());
//                });

        return containsBread;

    }


}
