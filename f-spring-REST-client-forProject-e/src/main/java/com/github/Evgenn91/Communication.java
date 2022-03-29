package com.github.Evgenn91;

import com.github.Evgenn91.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Component
public class Communication {

    @Autowired
    public RestTemplate restTemplate;

    private final String URL = "http://localhost:8080/api/employees";

    public List<Employee> showAllEmployee() {
        //ParameterizedTypeReference<List<Employee>>() {} - это помощник, чтобы передать generic тип, в нашем случае это - List <Employee>
        ResponseEntity<List <Employee>> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {}); /* null т.к. тело метода пустое */
        List<Employee> allEmployees = responseEntity.getBody();
        return allEmployees;
    }

    public Employee getEmployee(int id) {
        Employee employee = restTemplate.getForObject(URL + "/" + id, Employee.class);
        return employee;
    }

//    метод сохранения и изменения объкта одновременно
    public void saveEmployee(Employee employee) {
        int id = employee.getId();
        if (id == 0) {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL, employee, String.class); /* employee - это то, что мы добавляем в тело метода post*/
            System.out.println(responseEntity.getBody());/* будет выводится уже новодобавленный работник */
        } else { restTemplate.put(URL, employee); }// это обновление работника
    }


    public void deleteEmployee(int id) {
        restTemplate.delete(URL + "/" + id);
    }
}
