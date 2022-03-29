package com.github.Evgenn91.rest.controller;

import com.github.Evgenn91.rest.entity.Employee;
import com.github.Evgenn91.rest.exception_handling.EmployeeIncorrectData;
import com.github.Evgenn91.rest.exception_handling.NoSuchEmployeeException;
import com.github.Evgenn91.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) { throw new NoSuchEmployeeException("Объект небыл передан!!!!"); }/* добавили эту строчку, когда сделали обработку исключений(смотри ниже) */
        return employee;/* преобразование в json происходит автоматически */
    }

    @PostMapping("/employees") /* PostMapping - связывает HTTP запрос, использующий HTTP метод POST с методом контроллера */
    public Employee addNewEmployee(@RequestBody Employee employee) { /* @RequestBody - связывает тело HTTP метода с параметром метода Controller */
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) { throw new NoSuchEmployeeException("работника с таким id нету в базе данных"); }
        employeeService.deleteEmployee(id);
        return "Employee with ID = " + id + " was deleted";
    }

    //Мы данные методы вынесли отдельно, в папку exception_handling с помощью аннотации @ControllerAdvice (класс EmployeeGlobalExceptionHandler)
//    /**
//     * @ExceptionHandler - отмечается метод, ответственный за обработку исключений
//     */
//    //ResponseEntity - это обертка HTTP Response
//    //EmployeeIncorrectData - тип объекта, который добавляется в HTTP Response
//    //NoSuchEmployeeException - exception на который должен реагировать данный метод
//    @ExceptionHandler
//    public ResponseEntity<EmployeeIncorrectData> handleException(NoSuchEmployeeException exception) {
//        EmployeeIncorrectData data = new EmployeeIncorrectData();
//        data.setInfo(exception.getMessage()); /* взяли то, что написали в исключении */
//        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
//    }
//
//    //метод реагирующий на любой Exception
//    @ExceptionHandler
//    public ResponseEntity<EmployeeIncorrectData> handleException(Exception exception) {
//        EmployeeIncorrectData data = new EmployeeIncorrectData();
//        data.setInfo(exception.getMessage());
//        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
//    }
}
