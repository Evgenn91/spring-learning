package com.github.Evgenn91.a_simpleMVCProject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * методы в контроллере могут:
 * - называться как угодно
 * - иметь параметры
 * - возвращать не только Spring
 */

@Controller /* это специальный Component*/
public class MyFirstController {

    @RequestMapping("/")/*связывает url адрес с методом в нашем контроллере(эта аннотация, повешанная над классом, связывает url в ней со всеми методами в классе)*/
    public String showFirstView()/*название метода не несет никакой смысловой нагрузки*/{
        return "a_first-view"; /*благодаря prefix и suffix добавятся к этому названию оставшиеся части для полного наименования*/
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails(){
        return "a_ask-emp-details-view";
    }

    //первый способ чтения данных из формы:
//    @RequestMapping("/showDetails")
//    public String showEmpDetails(HttpServletRequest request, Model model){
//        //достаем данные, которые к нам пришли(параметр передавался в url)
//        String empName = request.getParameter("employeeName");
//        empName = "Mr. " + empName;
//        //добавляем значение в определенное место на странице(мы его определили с помощъю синтаксиса jsp)
//        model.addAttribute("nameAttribute", empName); /*nameAttribute - это имя параметра на странице(написанное с помощъю синтаксиса jsp)*/
//        return "show-emp-details-view";
//    }

    //другая техника чтения данных из формы:
    //@RequestParam("employeeName") - эта аннотация позволяет привязывать поле формы с названием "employeeName" к параметру методы из контроллера
    @RequestMapping("/showDetails")
    public String showEmpDetails(@RequestParam("employeeName") String empName, Model model){
        empName = "Mr. " + empName;
        //добавляем значение в определенное место на странице(мы его определили с помощъю синтаксиса jsp)
        model.addAttribute("nameAttribute", empName); /*nameAttribute - это имя параметра на странице(написанное с помощъю синтаксиса jsp)*/
        return "a_show-emp-details-view";
    }
}
