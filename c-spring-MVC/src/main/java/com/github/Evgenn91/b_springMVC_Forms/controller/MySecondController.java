package com.github.Evgenn91.b_springMVC_Forms.controller;

import com.github.Evgenn91.b_springMVC_Forms.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * методы в контроллере могут:
 * - называться как угодно
 * - иметь параметры
 * - возвращать не только Spring
 */

@Controller /* это специальный Component*/
@RequestMapping("/employee")
public class MySecondController {

    @RequestMapping("/askDetails")
    public String askEmployeeDetails(Model model){
        Employee emp = new Employee();
        emp.setName("Ivan");
        emp.setSurname("Ivanov");
        emp.setSalary(500);
        model.addAttribute("employee", emp);
        return "b_ask-employee-view";
    }


    //@ModelAttribute("employee") -
    @RequestMapping("/showDetails")
    public String showEmpDetails(@ModelAttribute("employee") Employee emp){
        String name = emp.getName();
        emp.setName("Mr. "+name);
        return "b_show-employee-view";
    }
}
