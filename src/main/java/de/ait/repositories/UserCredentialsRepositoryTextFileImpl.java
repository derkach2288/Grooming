package de.ait.repositories;

import de.ait.models.UserCredential;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class UserCredentialsRepositoryTextFileImpl implements UserCredentialsRepository {
    String fileName;
    public UserCredentialsRepositoryTextFileImpl(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public List<UserCredential> findAll() {
        List<UserCredential> userCredentials = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            while (line!=null) {
                UserCredential userCredential = parsLine(line);
                userCredentials.add(userCredential);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Такого файла нет");
        } catch (IOException e) {
            System.out.println("Произошла ошибка");
        }
        return userCredentials;
    }
    @Override
    public void save(UserCredential userCredential) {
        try(BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter(fileName, true))) {
            bufferedWriter.newLine();
            bufferedWriter.write(convert(userCredential));
        } catch (IOException e) {
            System.out.println("Произошла ошибка");
        }
    }

    private String convert(UserCredential userCredential) {
        String line = "login" + ":" + userCredential.getLogin() + "|" + "password" + ":" + userCredential.getPassword();
        return line;
    }
    public UserCredential parsLine(String line) {
        Pattern pattern = Pattern.compile("[:|]");
        String[] parsed = pattern.split(line);
        String login = parsed[1];
        String password = parsed[3];
        return new UserCredential(login, password);
    }
}
