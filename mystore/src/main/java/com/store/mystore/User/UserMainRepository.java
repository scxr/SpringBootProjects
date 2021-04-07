package com.store.mystore.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.servlet.annotation.WebFilter;

public interface UserMainRepository extends JpaRepository<UserMain, Long> {

    @Modifying
    @Query("UPDATE UserMain u SET u.password=?1 WHERE u.userID=?2")
    void changePassword(String password, long id);

}
