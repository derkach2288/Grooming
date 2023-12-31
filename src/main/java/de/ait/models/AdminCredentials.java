package de.ait.models;

public class AdminCredentials {
    private String login;
    private String password;

    public AdminCredentials(String adminID, String password) {
        this.login = adminID;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdminCredentials{" + "adminID: " + login + '\'' + ", password: " + password + '\'' + '}';
    }
}
