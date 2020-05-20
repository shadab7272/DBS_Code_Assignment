package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class TeamHierarchy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String empid;

    private String managerid;

}