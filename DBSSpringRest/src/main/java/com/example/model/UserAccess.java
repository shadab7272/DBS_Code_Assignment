package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "USERACCESS")
@Data
@NamedStoredProcedureQueries({
@NamedStoredProcedureQuery(name = "GET_TOTAL_CARS_BY_MODEL",
                                procedureName = "GET_TOTAL_CARS_BY_MODEL",
    resultClasses = UserAccess.class)})
public class UserAccess {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private String empid;

	    private String accessKey;

	    private String country;
	    
	    private String subuser;
	    
	    private String subuserAccessKey;
	    
	    private String subuserCountry;
	    

}
