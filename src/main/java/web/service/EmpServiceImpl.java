package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.EmpDao;
import web.entity.Employee;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    private final EmpDao empDao;

    public EmpServiceImpl(EmpDao empDao) {
        this.empDao = empDao;
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return empDao.getAllEmployees();
    }

    @Override
    @Transactional
    public Employee saveEmployee(Employee employee) {
        empDao.saveEmployee(employee);
        return employee;
    }

    @Override
    @Transactional
    public Employee getEmployees(long id) {
        return empDao.getEmployees(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(long id) {
        empDao.deleteEmployee(id);
    }
}
