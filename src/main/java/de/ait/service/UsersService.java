package de.ait.service;

import de.ait.dto.UserDto;
import de.ait.models.Grooming;
import de.ait.models.User;

import java.util.List;

public interface UsersService {

    List<String> getSecondName();
    String findSecondName(String secondName);
    List<User> findAll();

    void add(UserDto userDto);

}
