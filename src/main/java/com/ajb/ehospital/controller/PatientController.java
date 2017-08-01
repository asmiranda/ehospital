package com.ajb.ehospital.controller;

import com.ajb.ehospital.model.Patient;
import com.ajb.ehospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService service;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Patient>> getAll() {
        List<Patient> lst = service.getAll();
        return new ResponseEntity<List<Patient>>(lst, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Patient> getById(@PathVariable("id") String id) {
        Patient e = service.findById(id);
        return new ResponseEntity<Patient>(e, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Void> add(@RequestBody Patient user, UriComponentsBuilder ucBuilder) {
        service.save(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/employee/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Patient> updateUser(@PathVariable("id") String id, @RequestBody Patient user) {
        System.out.println("Updating User " + id);

        Patient currentUser = service.findById(id);

        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
        }

        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setAge(user.getAge());

        service.update(currentUser);
        return new ResponseEntity<Patient>(currentUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Patient> deleteUser(@PathVariable("id") String id) {
        System.out.println("Fetching & Deleting User with id " + id);

        Patient user = service.findById(id);
        if (user == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
        }

        service.delete(id);
        return new ResponseEntity<Patient>(HttpStatus.NO_CONTENT);
    }
}
