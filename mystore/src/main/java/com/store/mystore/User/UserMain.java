package com.store.mystore.User;

import java.time.LocalDate;
import java.util.Random;

public class UserMain {
    private String username;
    private String password;
    private LocalDate joinDate;
    private long userID;
    private long userRep;
    private long userSales;
    Random rand = new Random();
    public UserMain(String username, String password) {
        this.username = username;
        this.password = password;
        this.joinDate = LocalDate.now();
        this.userID = rand.nextLong();
        this.userRep=0;
        this.userSales = 0;
    }

    public UserMain(String username, String password, LocalDate joinDate, long userID, long userRep, long sales) {
        this.username = username;
        this.password = password;
        this.joinDate = joinDate;
        this.userID = userID;
        this.userRep = userRep;
        this.userSales = sales;
    }

    public UserMain(){}


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public long getUserRep() {
        return userRep;
    }

    public void setUserRep(long userRep) {
        this.userRep = userRep;
    }

    public long getUserSales() {
        return userSales;
    }

    public void setUserSales(long userSales) {
        this.userSales = userSales;
    }

    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }
}

