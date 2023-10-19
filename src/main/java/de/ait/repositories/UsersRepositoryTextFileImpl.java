package de.ait.repositories;

import de.ait.models.User;

import java.io.*;
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

    @Override
    public void addUser(String lineUser) {
        try(FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.newLine();
            bufferedWriter.write(lineUser);

        } catch (IOException e) {
            System.out.println("Произошла ошибка");
        }
    }

    public static User parsLine(String line){
        String[] parsed = line.split("\\|");
        String firstName = parsed[0];
        String secondName = parsed[1];
        String breed = parsed[2];
        String nickname = parsed[3];
        String address = parsed[4];
        String eMail = parsed[5];
        return new User(firstName, secondName, breed, nickname, address, eMail);
    }
}
