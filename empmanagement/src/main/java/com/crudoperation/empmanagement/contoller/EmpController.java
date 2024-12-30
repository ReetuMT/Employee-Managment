package com.crudoperation.empmanagement.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crudoperation.empmanagement.enitity.Employee;
import com.crudoperation.empmanagement.service.EmpService;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
public class EmpController {

    @Autowired
    private EmpService empService;

    // Add Employee
    @PostMapping("/addemp")
    public Employee addEmployee(@RequestBody Employee emp) {
        return empService.addemployee(emp);
    }

    // Get All Employees
    @GetMapping("/getemployee")
    public List<Employee> getAllEmployees() {
        return empService.getAllEmployee();
    }

    // Update Employee
    @PostMapping("/updateemployee")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee emp) {
        try {
        	Employee updatedEmp = empService.updateEmploye(emp);
            return new ResponseEntity<>(updatedEmp, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Delete Employee by ID
    @GetMapping("/deleteEmp/{id}")
    public Boolean deleteEmployee(@PathVariable int id) {
        return empService.deleteEmpl(id);
    }
}
