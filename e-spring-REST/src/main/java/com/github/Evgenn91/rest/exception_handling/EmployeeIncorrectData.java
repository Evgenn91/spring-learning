package com.github.Evgenn91.rest.exception_handling;

/**
 * это класс json, который будет отображаться, когда будут ошибки при передачи данных
 * тоесть при передаче данных этот класс преобразуется в json и выводится на экран
 */
public class EmployeeIncorrectData {

    private String info;

    public EmployeeIncorrectData() {
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
