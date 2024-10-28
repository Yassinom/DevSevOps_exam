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

    public String addEmployee(Employees employee) {
        if (employee != null) {
            employeesRepository.save(employee);
            return "Employee is well added, Employe est bien ajoute";
        } return "Please do not leave the Name or Mail fields empty";
    }

    public boolean deleteEmployee(String name) {
        Employees employee = employeesRepository.findByName(name);
        if (employee != null) {
            employeesRepository.delete(employee);
            return true;
        } return false;
    }

    public String getEmployee(Long id) {
        Optional<Employees> employee = employeesRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get().getName();
        }
        return "Employee Not Found, Employe Introuvable";
    }

    public String updateEmployee(Long id, Employees employee) {
        Optional<Employees> employee1 = employeesRepository.findById(id);
        if (employee1.isPresent()) {
            Optional<Employees> employeeSameMail = Optional.ofNullable(employeesRepository.findByMail(employee.getMail()));
            if (employeeSameMail.isPresent()) {
                return "Email already in use, Email dejà utilise !";
            }
            employee1.get().setName(employee.getName());
            employee1.get().setMail(employee.getMail());
            return "Mail and Name Updated Successfully !";
        }
        return "Employee Not Found with this id, Employe Introuvable avec l'id saisie";
    }
}
