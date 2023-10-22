package de.ait.service;

import de.ait.dto.UserDto;
import de.ait.models.User;

import java.util.List;

public interface UsersService {

    List<String> getSecondNames();
    String findUserBySecondName(String secondName);
    List<User> findAll();
    void printAllUsers();
    User getUserBySecondName(String secondName);
    void add(UserDto userDto);

}
