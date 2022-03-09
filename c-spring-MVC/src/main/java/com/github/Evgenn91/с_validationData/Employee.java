package com.github.Evgenn91.с_validationData;

import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;

public class Employee {
//    этой аннотацией из hibernate-validator мы говорим, что слово должно быть не меньше 2ух символов
    @Size(min = 2, message = "имя не должно быть меньше 2ух символов")
    private String name;
    private String surname;
    private int salary;
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
