package com.github.Evgenn91.dao;

import com.github.Evgenn91.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Repository - это специализированный @Component
 * Данная аннотация используется для ДАО.
 * При поиске компонентов, Spring будета регистрировать все DAO
 * с аннотацией @Repository в Spring Container-e
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
//    @Transactional - ненужно прописывать, т.к. использование транзакций прописали в конфигурационном файле(тоесть передали эту работу Spring) и перенесли эта аннотацию в Service
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("from Employee", Employee.class); /*красным выделено, это нормально(если нужно убрать, то это в настройках IntellijIdea делается)*/
        List<Employee> allEmployees = query.getResultList();
        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
//        session.save(employee);
        session.saveOrUpdate(employee);/* эту строчку изменили(старый вариант сверху), когда добавили скрытую форму передачи id на страницу employee-info */
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("delete from Employee where id =:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();/* отвечает как за обновление так и за удаление */
    }
}
