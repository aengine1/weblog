package com.weblog.controller;

import com.weblog.service.IIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

//@RestController
@Controller
public class IndexAdminController {

    @Autowired
    private IIndexService indexService;

    @RequestMapping("/admin")
    public String index() {
        return "Welcome to Admin, Dao名称为：" + indexService.Hello();
    }

    @RequestMapping("/admin1")
    public String index1() {
        return "index";
    }

}
