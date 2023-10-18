package de.ait.service;

import java.util.List;

public interface UsersService {

    List<String> getNames(); // имена всех пользователей
    String getSecondNameOfOldest(); // фамилия старшего пользователя
}
