package com.fdzc.springboot01.filter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {
    @RequestMapping("/test")
    public String testFilter(){
        System.out.println("filter执行成功");
        return "filter";
    }
}