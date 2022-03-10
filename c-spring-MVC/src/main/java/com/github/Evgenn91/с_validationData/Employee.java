package com.github.Evgenn91.с_validationData;

import com.github.Evgenn91.с_validationData.validation.CheckEmail;

import javax.validation.constraints.*;
import java.util.HashMap;
import java.util.Map;

public class Employee {
//    этой аннотацией из hibernate-validator мы говорим, что слово должно быть не меньше 2ух символов
    @Size(min = 2, message = "имя не должно быть меньше 2ух символов")
    private String name;
    @NotEmpty(message = "имя не должно быть пустым")
    private String surname;
    @Min(value = 5, message = "значение не может быть меньше 5")
    @Max(value = 100, message = "значение не может быть больше 100")
    private int salary;
    @Pattern(regexp = "\\d{3}-\\d{2}-\\d{2}",message = "пожалуйста используйте формат ххх-хх-хх")
    private String phoneNumber;
    @CheckEmail()/* это моя аннотация(реализация в папке validation)*/
    private String email;
    private String department;
    private Map<String, String> departments;
    private String carBrand;
    private Map<String,String> carBrands;
    private String[] languages;
    private Map<String, String> languageList;

    public Employee() {
        this.departments = new HashMap<>();
        this.carBrands = new HashMap<>();
        this.languageList = new HashMap<>();
        departments.put("IT","Information Technology");
        departments.put("HR","Human Resourses");
        departments.put("sales","Sales");
        carBrands.put("BMW","BMW");
        carBrands.put("Audi","Audi");
        carBrands.put("Mercedes Bens","Mercedes");
        languageList.put("English","EN");
        languageList.put("Deutch","DE");
        languageList.put("French","FR");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Map<String, String> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(Map<String, String> languageList) {
        this.languageList = languageList;
    }

    public Map<String, String> getCarBrands() {
        return carBrands;
    }

    public void setCarBrands(Map<String, String> carBrands) {
        this.carBrands = carBrands;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Map<String, String> getDepartments() {
        return departments;
    }

    public void setDepartments(Map<String, String> departments) {
        this.departments = departments;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", department='" + departments + '\'' +
                '}';
    }
}
