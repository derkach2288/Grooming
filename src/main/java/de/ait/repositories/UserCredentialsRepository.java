package de.ait.repositories;

import de.ait.models.UserCredential;

import java.util.List;

public interface UserCredentialsRepository {
    public List<UserCredential> findAll();

    void save(UserCredential userCredential);

}
