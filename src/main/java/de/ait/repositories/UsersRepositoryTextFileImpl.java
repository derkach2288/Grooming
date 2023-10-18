package de.ait.repositories;

import de.ait.models.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryTextFileImpl implements UsersRepository{
    String fileName; // имя файла

    public UsersRepositoryTextFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try(FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = bufferedReader.readLine();
            while (line!=null){
                User user = parsLine(line);
                users.add(user);
//                users.add(parsLine(line));
                line = bufferedReader.readLine();
            }
        } catch (IOException e){
            System.out.println("Произошла ошибка");
        }
        return users;
    }

    public static User parsLine(String line){
        String[] patsed = line.split("\\|");
        String firstName = patsed[0];
        String secondName = patsed[1];
        int age = Integer.parseInt(patsed[2]);
        double height = Double.parseDouble(patsed[3]);
        return new User(firstName, secondName, age, height);
    }
}
