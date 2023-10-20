package de.ait.service;

import de.ait.models.UserCredential;
import de.ait.repositories.UserCredentialsRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class UserCredentialsServiceImpl implements UserCredentialsService {
    UserCredentialsRepository userCredentialsRepository;

    public UserCredentialsServiceImpl(UserCredentialsRepository userCredentialsRepository) {
        this.userCredentialsRepository = userCredentialsRepository;
    }

    @Override
    public List<UserCredential> findAll() {
        return userCredentialsRepository.findAll();
    }

    @Override
    public void add(UserCredential userCredential) {
        userCredentialsRepository.save(userCredential);
    }

    public String getUserLogin(String login) {
        List<UserCredential> userCredentialsList = userCredentialsRepository.findAll();
        UserCredential userCredential = userCredentialsList.stream()
                .filter(uc -> uc.getLogin().equals(login))
                .findAny()
                .orElseGet(() -> null);
        if (userCredential == null) {
            return "Такого логина нет";
        } else return userCredential.getLogin();
    }

    public String getUserPassword(String password) {
        List<UserCredential> userCredentialsList = userCredentialsRepository.findAll();
        UserCredential userCredential = userCredentialsList.stream()
                .filter(uc -> uc.getPassword().equals(password))
                .findAny()
                .orElseGet(() -> null);
        if (userCredential == null) {
            return "Такого пароля нет";
        } else return userCredential.getPassword();
    }
}
