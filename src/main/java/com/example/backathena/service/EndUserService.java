package com.example.backathena.service;

import com.example.backathena.entity.Book;
import com.example.backathena.entity.EndUser;
import com.example.backathena.entity.User;
import com.example.backathena.repository.BookRepository;
import com.example.backathena.repository.EndUserRepository;
import org.apache.tomcat.jni.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EndUserService {

    private final EndUserRepository endUserRepository;


    @Autowired
    public EndUserService(EndUserRepository endUserRepository){
        this.endUserRepository = endUserRepository;
    }

    public Optional<EndUser> getEndUserById(Long userId) {
        return endUserRepository.findById(userId);
    }

    public Optional<EndUser> getUserByEmail(String email){
        return endUserRepository.findByEmail(email);
    }

    public EndUser save(EndUser endUser) {
        endUser.setRole("consumer");
        return endUserRepository.save(endUser);
    }

    public EndUser login(EndUser user) {
        return verifyUser(user);
    }

    private EndUser verifyUser(EndUser user) {
        Optional<EndUser> verifyUser = getUserByEmail(user.getEmail());
        if (verifyUser.isPresent()){
            if (Objects.equals(verifyUser.get().getPassword(), user.getPassword())){
                return verifyUser.get();
            }else{
                return new EndUser();
            }
        }else{
            return new EndUser();
        }
    }
}
