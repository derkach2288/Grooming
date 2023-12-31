package de.ait.dto;

public class UserDto {
    private String firstName;
    private String secondName;
    private String breed;
    private String nickname;
    private String address;
    private String eMail;

    public UserDto(String firstName, String secondName, String breed, String nickname, String address, String eMail) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.breed = breed;
        this.nickname = nickname;
        this.address = address;
        this.eMail = eMail;
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

    @Override
    public String toString() {
        return "UserDto{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", breed='" + breed + '\'' +
                ", nickname='" + nickname + '\'' +
                ", address='" + address + '\'' +
                ", eMail='" + eMail + '\'' +
                '}';
    }
}
