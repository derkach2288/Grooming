package de.ait.models;

public class AdminCredentials {
    private String adminID;
    private String password;

    public AdminCredentials(String adminID, String password) {
        this.adminID = adminID;
        this.password = password;
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdminCredentials{" + "adminID: " + adminID + '\'' + ", password: " + password + '\'' + '}';
    }
}
