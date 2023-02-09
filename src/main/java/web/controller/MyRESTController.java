package web.controller;

import org.springframework.web.bind.annotation.*;
import web.entity.Employee;
import web.exception_handeling.NoSuchEmployeeException;
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
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable long id) {
        Employee employee = empService.getEmployees(id);

        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " +
                    id + " in Database");
        }
        return employee;
    }


    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        empService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        empService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable long id) {
        Employee employee = empService.getEmployees(id);

        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " +
                    id + " in Database");
        }
        empService.deleteEmployee(id);
        return "The employee with ID = " + id + " was deleted";
    }
}
