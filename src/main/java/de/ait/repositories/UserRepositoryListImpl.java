package de.ait.repositories;

import de.ait.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserRepositoryListImpl implements UsersRepository{

    private List<User> usersList = new ArrayList<>(List.of(
            new User("John", "Smith", "PUG", "Dolly"
                    ,"23456, Stuttgart, Hauptstrasse 3", "dolly@gmail.com"),
            new User("Jack", "Russel", "JACK_RUSSEL", "Jacky",
                    "12345, Berlin, Hauptstrasse 4", "Jacky@gmail.com"),
            new User("Max", "Hoffman", "SAMOYED", "Gin",
                    "43268, Hamburg, Hauptstrasse 8", "gin@gmail.com")

    ));
    @Override
    public List<User> findAll() {
        return usersList;
    }

    @Override
    public void addUser(String lineUser) {
        User newUser = parsLine(lineUser);
        usersList.add(newUser);
    }
    private User parsLine(String lineUser){
        String[] parsed = lineUser.split("\\|");
        String firstName = parsed[0];
        String secondName = parsed[1];
        String breed = parsed[2];
        String nickname = parsed[3];
        String address = parsed[4];
        String eMail = parsed[5];
        String userId = UUID.randomUUID().toString();
        return new User(firstName, secondName, breed, nickname, address, eMail, userId);
    }
}
