package com.doan1.doan1_quanlipm.services;

import com.doan1.doan1_quanlipm.entities.Users;
import com.doan1.doan1_quanlipm.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public int findUserByUsernameAndPassword (String username, String password){
        return userRepository.findUserByUsernameAndPassword(username,password);
    }
    @Transactional
    public Users findUserByUsername(String username){
        return userRepository.findUserByUsername(username);
    }
}
