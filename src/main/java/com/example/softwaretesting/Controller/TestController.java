package com.example.softwaretesting.Controller;

import com.example.softwaretesting.entry.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "Hello World";
    }

    @RequestMapping("/student")
    public Student student(){
        return new Student("SX2316078","韩逸轩","软件测试");
    }
}
