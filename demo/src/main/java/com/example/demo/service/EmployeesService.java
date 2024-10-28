package com.example.demo.service;


import com.example.demo.model.Employees;
import com.example.demo.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeesService {

    @Autowired
    private EmployeesRepository employeesRepository;

    public boolean addEmployee(Employees employee) {
        if (employee != null) {
            employeesRepository.save(employee);
            return true;
        } return false;
    }

    public boolean deleteEmployee(String name) {
        Employees employee = employeesRepository.findByName(name);
        if (employee != null) {
            employeesRepository.delete(employee);
            return true;
        } return false;
    }

    public Employees getEmployee(Long id) {
        Optional<Employees> employee = employeesRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        return null;
    }

    public boolean updateEmployee(Long id, String name) {
        Optional<Employees> employee = employeesRepository.findById(id);
        if (employee.isPresent()) {
            employee.get().setName(name);
            return true;
        }
        return false;
    }
}
