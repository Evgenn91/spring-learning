package com.github.Evgenn91.service;

import com.github.Evgenn91.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees(); /* это точно такой же метод, как и в интерфейсе в папке dao */

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);
}
