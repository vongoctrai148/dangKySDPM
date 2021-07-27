package com.doan1.doan1_quanlipm.repositories;

import com.doan1.doan1_quanlipm.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<Users, String> {
    @Query("select count(u.username) from Users u where u.username = ?1 and u.passwords = ?2")
    int findUserByUsernameAndPassword(String username, String password);
    @Query("select u from Users u where u.username = ?1")
    Users findUserByUsername(String username);
}
