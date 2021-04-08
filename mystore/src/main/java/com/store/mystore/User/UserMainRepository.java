package com.store.mystore.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.servlet.annotation.WebFilter;
import java.util.Optional;

public interface UserMainRepository extends JpaRepository<UserMain, Long> {

    @Query("SELECT u FROM UserMain u WHERE u.userID=?1")
    Optional<UserMain> checkById(long id);


    @Modifying
    @Query("UPDATE UserMain u SET u.password=?1 WHERE u.userID=?2")
    void changePassword(String password, long id);

    @Query("SELECT u FROM UserMain u WHERE u.username=?1")
    Optional<UserMain> checkByUname(String email);



}
