package com.ajb.ehospital.service;

import com.ajb.ehospital.model.Patient;
import com.ajb.ehospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientRepository repository;

    public List<Patient> getAll() {
        return repository.findAll();
    }

    public Patient findById(String id) {
        Patient e = repository.findOne(id);
        return e;
    }

    public void save(Patient user) {
        repository.save(user);
    }

    public void update(Patient current) {
        repository.save(current);
    }

    public void delete(String id) {
        repository.delete(id);
    }
}
