package com.aug.jma;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HelloWorld {
    
    @RequestMapping(method=RequestMethod.GET)
    public String printHello(ModelMap modelMap){
        modelMap.addAttribute("msg", "Hello World!");
        return "hello";
    }
}
