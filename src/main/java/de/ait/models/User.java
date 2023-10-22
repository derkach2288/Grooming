package de.ait.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private String firstName;
    private String secondName;
    private String breed;
    private String nickname;
    private String address;
    private String eMail;
    String userId;

    public User(String firstName, String secondName, String breed, String nickname, String address, String eMail, String userId) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.breed = breed;
        this.nickname = nickname;
        this.address = address;
        this.eMail = eMail;
        this.userId = userId;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", breed='" + breed + '\'' +
                ", nickname='" + nickname + '\'' +
                ", address='" + address + '\'' +
                ", eMail='" + eMail + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) && Objects.equals(secondName, user.secondName) && Objects.equals(breed, user.breed) && Objects.equals(nickname, user.nickname) && Objects.equals(address, user.address) && Objects.equals(eMail, user.eMail) && Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, breed, nickname, address, eMail, userId);
    }
}
