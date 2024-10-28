package com.example.demo.contoller;


import com.example.demo.model.Employees;
import com.example.demo.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/employee")
public class EmployeesController {

    @Autowired
    private EmployeesService employeesService;

    @PostMapping("/addEmployee")
    public String addEmployee(@RequestBody Employees employee) {
        return employeesService.addEmployee(employee);
    }

    @PostMapping("/deleteEmployee/{name}")
    public boolean deleteEmployee(@PathVariable String name) {
        return employeesService.deleteEmployee(name);
    }

    @GetMapping("/getEmployee/{id}")
    public String getEmployee(@PathVariable Long id) {
        return employeesService.getEmployee(id);
    }

    @PutMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employees employee) {
        return employeesService.updateEmployee(id, employee);
    }
}
