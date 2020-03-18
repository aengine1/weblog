package com.weblog.controller;

import com.weblog.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class LoginController {
    /*
        登陆页面
     */
    @RequestMapping("/loginUser")
//    @ResponseBody
    public String loginUser(User user, Model model) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getUserPwd());
        try {
            subject.login(token);
            System.out.println("登陆成功");
            return "redirect:/user/index";
        } catch (UnknownAccountException e) {
            //e.printStackTrace();
            model.addAttribute("msg", "用户名不存在");
            return "login";
        } catch (IncorrectCredentialsException e) {
            //e.printStackTrace();
            model.addAttribute("msg", "密码错误");
            return "login";
        }catch (Exception e) {
            //e.printStackTrace();
            model.addAttribute("msg", "未知错误");
            return "login";
        }
    }
    /*
        未权限页面
     */
    @RequestMapping("/noAuth")
    public String noAuth(){
        return "noAuth";
    }
    /*
        index页面
     */
    @RequestMapping("/index")
    public String index(Model model){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("username", user.getUserName());
        return "index";
    }
    /*
        登陆页面
     */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    /*
            登陆页面
         */
    @RequestMapping("/login/out")
    public String loginOut(){
        return "login";
    }

}
