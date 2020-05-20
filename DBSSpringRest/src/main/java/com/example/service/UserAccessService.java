package com.example.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.model.UserAccess;
import com.example.model.UserAccessRespository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

@Service

@RequiredArgsConstructor
public class UserAccessService {
    private  UserAccessRespository userAccessRespository;
    private UserAccess userAccess;
    private EntityManager entityManager;

    public List<UserAccess> findAll() {
        return userAccessRespository.findAll();
    }

    public Optional<UserAccess> findById(Long id) {
        return userAccessRespository.findById(id);
    }

    public UserAccess save(UserAccess user) {
        return userAccessRespository.save(user);
    }

    public void deleteById(Long id) {
    	userAccessRespository.deleteById(id);
    }
    public List<UserAccess> createNamedStoredProcedureQuery(String empid) {
    	StoredProcedureQuery findByYearProcedure = entityManager.createNamedStoredProcedureQuery("INSERT_USERACCESS_DATA").setParameter(empid, userAccess);
    	return findByYearProcedure.getResultList();
    }
}