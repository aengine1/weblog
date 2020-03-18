package com.weblog.controller;

import com.weblog.service.IIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@RestController
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private IIndexService indexService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Welcome to Admin, Dao名称为：" + indexService.Hello();
    }

//    @RequestMapping("/login")
//    public String login() {
//        return "login";
//    }
    @RequestMapping("/test")
    public String test() {
        return "noAuth";
    }


}
