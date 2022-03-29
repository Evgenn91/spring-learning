package com.github.Evgenn91.rest.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @ControllerAdvice - данной аннотацие отмечается класс, предоставляющий
 * функциональность GlobalExceptionHandler (в этом процессе используется AOP)
 */
@ControllerAdvice
public class EmployeeGlobalExceptionHandler {

        /**
     * @ExceptionHandler - отмечается метод, ответственный за обработку исключений
     */
    //ResponseEntity - это обертка HTTP Response
    //EmployeeIncorrectData - тип объекта, который добавляется в HTTP Response
    //NoSuchEmployeeException - exception на который должен реагировать данный метод
    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handleException(NoSuchEmployeeException exception) {
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exception.getMessage()); /* взяли то, что написали в исключении */
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    //метод реагирующий на любой Exception
    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handleException(Exception exception) {
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
