package com.example.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.StoredProcedureQuery;
import javax.validation.Valid;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.model.UserAccess;
import com.example.service.UserAccessService;
import com.example.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/users")
@Slf4j
@RequiredArgsConstructor
public class UserRoleControllerAPI {
    private final UserAccessService userAccessService = new UserAccessService();

    @GetMapping
    public ResponseEntity<List<UserAccess>> findAll() {
        return ResponseEntity.ok(userAccessService.findAll());
    }

    @PostMapping
    public ResponseEntity<UserAccess> create(@Valid @RequestBody UserAccess user) {
        return ResponseEntity.ok(userAccessService.save(user));
    }
	/*
	 * @GetMapping("/{id}") public ResponseEntity<User> findById(@PathVariable Long
	 * id) { Optional<User> stock = userService.findById(id); if
	 * (!stock.isPresent()) { //log.error("Id " + id + " is not existed");
	 * ResponseEntity.badRequest().build(); }
	 * 
	 * return ResponseEntity.ok(stock.get()); }
	 */
    
    @GetMapping("/insertuseraccessdata/{empid}")
    public List<UserAccess> getAllUserAccess(@PathVariable String empid) {
    	List<UserAccess> list =
        		userAccessService.createNamedStoredProcedureQuery(empid);
        return list;
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<UserAccess> update(@PathVariable Long id, @Valid @RequestBody UserAccess user) {
        if (!userAccessService.findById(id).isPresent()) {
            //log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(userAccessService.save(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!userAccessService.findById(id).isPresent()) {
           // log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        userAccessService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}