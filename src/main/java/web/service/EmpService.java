package web.service;

import web.entity.Employee;

import java.util.List;

public interface EmpService {
    List<Employee> getAllEmployees();
    Employee saveEmployee(Employee employee);
    Employee getEmployees(long id);
    void deleteEmployee(long id);
}
