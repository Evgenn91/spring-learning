package com.github.Evgenn91.boot.hspringboot.dao;

import com.github.Evgenn91.boot.hspringboot.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);
}
