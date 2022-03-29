package com.github.Evgenn91.service;

import com.github.Evgenn91.dao.EmployeeDao;
import com.github.Evgenn91.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Аннотацией @Servise - это специализированный @Component
 * Данной аннотацией отмечается класс, содержаший бизнес логику.
 * В иеархии компонентов приложения Service является соединительным
 * звеном между Controller и DAO
 */
@Service
public class EmployeeServiceImpl implements  EmployeeService{

    @Autowired
    private EmployeeDao employeeDao;

    @Transactional /* данную аннотацию мы перенесли сюда из DAO */
    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Transactional
    @Override
    public void saveEmployee(Employee employee) {
        employeeDao.saveEmployee(employee);
    }

    @Transactional
    @Override
    public Employee getEmployee(int id) {
        return employeeDao.getEmployee(id);
    }

    @Transactional
    @Override
    public void deleteEmployee(int id) {
        employeeDao.deleteEmployee(id);
    }
}
