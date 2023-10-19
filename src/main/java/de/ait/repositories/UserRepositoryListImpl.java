package de.ait.repositories;

import de.ait.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserRepositoryListImpl implements UsersRepository{

    private List<User> usersList = new ArrayList<>(List.of(
            new User("John", "Smith", "PUG", "Dolly"
                    ,"23456, Stuttgart, Hauptstrasse 3", "dolly@gmail.com", "01111"),
            new User("Jack", "Russel", "JACK_RUSSEL", "Jacky",
                    "12345, Berlin, Hauptstrasse 4", "Jacky@gmail.com", "02222"),
            new User("Max", "Hoffman", "SAMOYED", "Gin",
                    "43268, Hamburg, Hauptstrasse 8", "gin@gmail.com", "03333")

    ));
    @Override
    public List<User> findAll() {
        return usersList;
    }

    @Override
    public void save(User user) {
        usersList.add(user);
    }

}
