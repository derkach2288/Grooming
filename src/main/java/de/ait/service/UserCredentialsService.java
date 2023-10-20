package de.ait.service;

import de.ait.dto.UserDto;
import de.ait.models.User;
import de.ait.models.UserCredential;

import java.util.List;

public interface UserCredentialsService {
    List<UserCredential> findAll();
    void add(UserCredential userCredential);
    String getUserLogin(String login);
    String getUserPassword(String password);
}
