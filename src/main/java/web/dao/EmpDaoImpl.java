package web.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import web.entity.Employee;

import javax.persistence.Query;
import java.util.List;

@Repository
public class EmpDaoImpl implements EmpDao {
    private final SessionFactory sessionFactory;

    public EmpDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        Query query = (Query) session.createQuery("from Employee");

        return (List<Employee>) query.getResultList();
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployees(long id) {
        Session session = sessionFactory.getCurrentSession();
        return (Employee) session.get(Employee.class, id);
    }

    @Override
    public void deleteEmployee(long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = (Query) session.createQuery("delete from Employee where id =: employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
