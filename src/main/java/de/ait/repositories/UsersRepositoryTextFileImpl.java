package de.ait.repositories;

import de.ait.models.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    public void save(User user) {
        try(FileWriter fileWriter = new FileWriter(fileName, true); // append true - добавляет в конец файла, не
            // перезаписывает
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.newLine();
            bufferedWriter.write(convert(user));

        } catch (IOException e) {
            System.out.println("Произошла ошибка");
        }

    }

    private String convert(User user) {
        String line = user.getFirstName() + "|" + user.getSecondName() + "|"
                + user.getBreed() + "|" + user.getNickname() + "|" + user.getAddress()
                + "|" + user.geteMail() + "|" + user.getUserId();
        return line;
    }


    public static User parsLine(String line){
        String[] parsed = line.split("\\|");
        String firstName = parsed[0];
        String secondName = parsed[1];
        String breed = parsed[2];
        String nickname = parsed[3];
        String address = parsed[4];
        String eMail = parsed[5];
        String userId = parsed[6];
        return new User(firstName, secondName, breed, nickname, address, eMail, userId);
    }
}
