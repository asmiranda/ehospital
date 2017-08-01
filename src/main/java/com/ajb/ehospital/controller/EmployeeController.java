package com.ajb.ehospital.controller;

import com.ajb.ehospital.model.Employee;
import com.ajb.ehospital.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService service;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getAll() {
        List<Employee> lst = service.getAll();
        return new ResponseEntity<List<Employee>>(lst, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> getById(@PathVariable("id") String id) {
        Employee e = service.findById(id);
        return new ResponseEntity<Employee>(e, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Void> add(@RequestBody Employee user, UriComponentsBuilder ucBuilder) {
        service.save(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/employee/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateUser(@PathVariable("id") String id, @RequestBody Employee user) {
        System.out.println("Updating User " + id);

        Employee currentUser = service.findById(id);

        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }

        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setAge(user.getAge());

        service.update(currentUser);
        return new ResponseEntity<Employee>(currentUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Employee> deleteUser(@PathVariable("id") String id) {
        System.out.println("Fetching & Deleting User with id " + id);

        Employee user = service.findById(id);
        if (user == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }

        service.delete(id);
        return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
    }
}
