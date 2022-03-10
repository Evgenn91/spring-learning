package com.github.Evgenn91.dao;

import com.github.Evgenn91.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Repository - это специализированный компонент
 * Данная аннотация используется для ДАО.
 * При поиске компонентов, Spring будета регистрировать все DAO
 * с аннотацией @Repository в
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
//    @Transactional - ненужно прописывать, т.к. использование транзакций пропимали в конфигурационном файле(тоесть передали эту работу Spring)
    public List<Employee> getAllEmployees() {

        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("from Employee", Employee.class); /*красным выделено, это нормально(если нужно убрать, то это в настройках IntellijIdea делается)*/
        List<Employee> allEmployees = query.getResultList();
        return allEmployees;
    }
}
