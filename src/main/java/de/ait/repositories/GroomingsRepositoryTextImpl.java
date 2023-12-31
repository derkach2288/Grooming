package de.ait.repositories;

import de.ait.models.Grooming;
import de.ait.models.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GroomingsRepositoryTextImpl implements GroomingsRepository{
    String fileName; // имя файла

    public GroomingsRepositoryTextImpl(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public List<Grooming> findAll() {
        List<Grooming> groomings = new ArrayList<>();
        try(FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = bufferedReader.readLine();
            while (line!=null){
                Grooming grooming = parsLine(line);
                groomings.add(grooming);
//                users.add(parsLine(line));
                line = bufferedReader.readLine();
            }
        } catch (IOException e){
            System.out.println("Произошла ошибка");
        }
        return groomings;

    }

    @Override
    public void save(Grooming grooming) {
//        String newGrooming = lineGrooming + "|" + UUID.randomUUID().toString();

        try(FileWriter fileWriter = new FileWriter(fileName, true); // append true - добавляет в конец файла, не
                                                                           // перезаписывает
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.newLine();
            bufferedWriter.write(convert(grooming));

        } catch (IOException e) {
            System.out.println("Произошла ошибка");
        }

    }


    public static Grooming parsLine(String line){
        String[] parsed = line.split("\\|");
        String title = parsed[0];
        String breeds = parsed[1];
        String period = parsed[2];
        double price = Double.parseDouble(parsed[3]);
        String groomingId = parsed[4];
        return new Grooming(title, breeds, period, price, groomingId);
    }

    public static String convert(Grooming grooming){
        String line = grooming.getTitle() + "|" + grooming.getBreed() + "|" +grooming.getPeriod()
                + "|" + grooming.getPrice() + "|" + grooming.getGroomingId();
        return line;
    }

}
