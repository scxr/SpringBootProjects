package com.store.mystore.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class UserMain {
    @Id
    @SequenceGenerator(
            name="UserMain_generator",
            sequenceName = "UserMain_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "UserMain_generator"

    )
    private long userID;

    private String username;
    private String password;
    private LocalDate joinDate;
    private long userRep;
    private long userSales;
    public UserMain(String username, String password) {
        this.username = username;
        this.password = password;
        this.joinDate = LocalDate.now();

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
    public String getPasswords(){return password;}

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


}

