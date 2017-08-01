package com.ajb.ehospital.service;

import com.ajb.ehospital.model.Employee;
import com.ajb.ehospital.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository repository;

    public List<Employee> getAll() {
        return repository.findAll();
    }

    public Employee findById(String id) {
        Employee e = repository.findOne(id);
        return e;
    }

    public void save(Employee user) {
        repository.save(user);
    }

    public void update(Employee current) {
        repository.save(current);
    }

    public void delete(String id) {
        repository.delete(id);
    }
}
