package com.github.Evgenn91.с_validationData.controller;

import com.github.Evgenn91.с_validationData.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/empWithValid")
public class MyThirdController {
    @RequestMapping("/askDetails")
    public String askEmployeeDetails(Model model){
        Employee emp = new Employee();
        emp.setName("Ivan");
        emp.setSurname("Ivanov");
        emp.setSalary(500);
        model.addAttribute("employ", emp);
        return "c_valid-ask-emp-view";
    }

    @RequestMapping("/showDetails")
//    аннотацией @Valid показываем, что атрибут employe должен пройти валидацию
//    BindingResult - это результат валидации employe(с его помощью узнаем прошла валидацию или нет(должен стоять сразу после модели))
    public String showEmpDetails(@Valid @ModelAttribute("employe") Employee emp, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "c_valid-ask-emp-view";
        } else {
            String name = emp.getName();
            emp.setName("Mr. "+name);
            return "c_valid-show-emp-view";
        }
    }
}
