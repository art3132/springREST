package web.dao;

import web.entity.Employee;

import java.util.List;

public interface EmpDao {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployees(long id);
    void deleteEmployee(long id);
}
