package com.github.Evgenn91.boot.hspringboot.dao;

import com.github.Evgenn91.boot.hspringboot.entity.Employee;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
    /**
     * раньше мы пользовались SessionFactory (это относится к Hibernate)
     * а теперь будем использовать JPA (EntityManager)
     * тоесть если мы захотим перейти с Hibernate на что то другое,
     * то легко это сделаем
     */
//    @Autowired
//    SessionFactory sessionFactory;

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
        Query query = entityManager.createQuery("from Employee");
        List<Employee> allEmployees = query.getResultList();
        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Employee newEmp = entityManager.merge(employee);
        employee.setId(newEmp.getId());/* назначим id нашему объекту Employee */
    }

    @Override
    public Employee getEmployee(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
