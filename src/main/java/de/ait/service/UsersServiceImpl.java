package de.ait.service;

import de.ait.dto.UserDto;
import de.ait.models.User;
import de.ait.repositories.UsersRepository;

import java.util.List;
import java.util.UUID;

public class UsersServiceImpl implements UsersService {
    UsersRepository usersRepository;
    UserDto userDto;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<String> getSecondName() {
        List<User> users = usersRepository.findAll();
        return users.stream().map(u -> u.getSecondName()).toList();
    }

    @Override
    public String findSecondName(String secondName) {
        List<User> users = usersRepository.findAll();
        User user = users.stream()
                .filter(u -> u.getSecondName().equals(secondName))
                .findFirst()
                .orElseGet(() -> null);

        return user == null ? "Такой фамилии нет" : user.toString();
    }

    @Override
    public List<User> findAll() {
        return usersRepository.findAll();
    }

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
