package com.company;

public class Admin {

    private String userName;
    private String passWord;
    private boolean fullAccess;

    public Admin(String adminUser, String passWord, boolean fullAccess) {
        this.userName = adminUser;
        this.passWord = passWord;
        this.fullAccess = fullAccess;
    }

    public String getadminUser() {return userName;}
    public String getPassWord() {return passWord;}
    public boolean getFullAccess() {return fullAccess;}
}
