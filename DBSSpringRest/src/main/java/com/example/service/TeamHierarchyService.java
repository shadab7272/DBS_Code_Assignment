package com.example.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.model.TeamHierarchy;
import com.example.model.TeamHierarchyRespository;

import java.util.List;
import java.util.Optional;

@Service

@RequiredArgsConstructor
public class TeamHierarchyService {
    private final TeamHierarchyRespository teamHierarchyRespository = null;

    public List<TeamHierarchy> findAll() {
        return teamHierarchyRespository.findAll();
    }

    public Optional<TeamHierarchy> findById(Long id) {
        return teamHierarchyRespository.findById(id);
    }

    public TeamHierarchy save(TeamHierarchy user) {
        return teamHierarchyRespository.save(user);
    }

    public void deleteById(Long id) {
    	teamHierarchyRespository.deleteById(id);
    }
}