package io.shiftleft.controller;

import io.shiftleft.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/{id}/share/salary")
    public void shareSalaryWithThirdParty(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);
        employee.shareSalaryWithThirdParty();
    }

    @PostMapping("/{id}/share/details")
    public void shareDetailsWithThirdParty(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);
        employee.shareDetailsWithThirdParty();
    }
}
