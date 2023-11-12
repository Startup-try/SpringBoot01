package com.fdzc.springboot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes(value={"sessionName","address"})
public class MVCController {

    @RequestMapping("/paramTest")
    public String ParamTest(@RequestParam(required = true) String name){
        System.out.println(name);
        return "testOk";//     /testOk.jsp
    }

    //    http://localhost:8080/paramTest?name=aaaaa
    @RequestMapping("/checkBoxTest")
    public String CheckBoxTest(int[] ids) {
        for (int i : ids) {
            System.out.println("i = " + i);
        }
        return "testOk";
    }
    //控制器到JSP的跳转--forward方式1
    @RequestMapping("/jsp1")
    public String view1() {
        System.out.println("控制器到JSP的跳转--forward方式1");
        return "testOk";
    }

    //控制器到JSP的跳转--forward方式2
    @RequestMapping("/jsp2")
    public String view2() {
        System.out.println("控制器到JSP的跳转--forward方式2");
        return "forward:/testOk.jsp";
    }
    //控制器到JSP的跳转--redirect方式
    @RequestMapping("/jsp3")
    public String view3() {
        System.out.println("控制器到JSP的跳转--redirect方式");
        return "redirect:/testOk.jsp";
    }








    //控制器到控制器的跳转--forward方式
    @RequestMapping("/forward1")
    public String forward1() {
        System.out.println("控制器到控制器的跳转--forward1");
        return "forward:/forward2";
    }

    @RequestMapping("/forward2")
    public String forward2() {
        System.out.println("控制器到控制器的跳转--forward2");
        return "testOk";
    }


    //控制器到控制器的跳转--redirect方式
    @RequestMapping("/redirect1")
    public String redirect1() {
        System.out.println("控制器到控制器的跳转--redirect1");
        return "redirect:/redirect2";
    }

    @RequestMapping("/redirect2")
    public String redirect2() {
        System.out.println("控制器到控制器的跳转--redirect2");
        return "testOk";
    }


    @RequestMapping("/scope1")
    public String scope1(HttpServletRequest request) {
        request.setAttribute("name", "request");
        return "result";
    }

    @RequestMapping("/scope2")
    public String scope2(ModelMap modelMap) {
        modelMap.addAttribute("name", "modelMap");
        return "result";
    }

    @RequestMapping("/scope3")
    public String scope3(Model model) {
        model.addAttribute("name", "model");
        return "result";
    }

    @RequestMapping("/session")
    public String view1(Model model) {
        model.addAttribute("age", 10);
        model.addAttribute("sessionName", "sessionValue");
        return "session";
    }




}
