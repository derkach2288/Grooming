package de.ait.repositories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class AdminRepositoryTextImpl implements AdminRepository {
    String fileName;
    public AdminRepositoryTextImpl(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public String getPassword() {
        String password = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));) {
                String line = bufferedReader.readLine();
                    password = parsePswdLine(line);
        } catch (IOException e) {
            System.out.println("Произошла ошибка");
        }
        return password;
    }
    @Override
    public String getAdminID() {
        String adminID = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));) {
            String line = bufferedReader.readLine();
            adminID = parseAdminIDline(line);
        } catch (IOException e) {
            System.out.println("Произошла ошибка");
        }
        return adminID;
    }

    public String parsePswdLine(String line){
        Pattern pattern = Pattern.compile("[:|]");
        String[] parsed = pattern.split(line);
        return parsed[3];
    }
    public String parseAdminIDline(String line){
        Pattern pattern = Pattern.compile("[:|]");
        String[] parsed = pattern.split(line);
        return parsed[1];
    }
}
