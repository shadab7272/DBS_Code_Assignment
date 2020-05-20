package com.example.service;


import lombok.RequiredArgsConstructor;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.model.UserRespository;

import java.util.List;
import java.util.Optional;

@Service

@RequiredArgsConstructor
public class UserService {
    private final UserRespository userRespository = null;

    public List<User> findAll() {
        return userRespository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRespository.findById(id);
    }

    public User save(User user) {
        return userRespository.save(user);
    }

    public void deleteById(Long id) {
    	userRespository.deleteById(id);
    }
    @Procedure("GET_TOTAL_CARS_BY_MODEL")
    public String storeUserAccessInfo(String empid) {
    	return "";
    }
}