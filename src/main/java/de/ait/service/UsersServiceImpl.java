package de.ait.service;

import de.ait.dto.UserDto;
import de.ait.models.User;
import de.ait.repositories.UsersRepository;

import java.util.UUID;

public class UsersServiceImpl implements UsersService{
    UsersRepository usersRepository;
    UserDto userDto;

    @Override
    public void add(UserDto userDto) {
        User user = new User(userDto.getFirstName(),
                userDto.getSecondName(),
                userDto.getBreed(),
                userDto.getNickname(),
                userDto.getAddress(),
                userDto.geteMail(),
                UUID.randomUUID().toString());
        usersRepository.save(user);
    }
}
