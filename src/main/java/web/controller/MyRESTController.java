package web.controller;

import org.springframework.web.bind.annotation.*;
import web.entity.Employee;
import web.service.EmpService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    private final EmpService empService;

    public MyRESTController(EmpService empService) {
        this.empService = empService;
    }

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        return empService.getAllEmployees();
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        return empService.saveEmployee(employee);
    }
}
