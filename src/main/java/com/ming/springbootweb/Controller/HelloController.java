package com.ming.springbootweb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.lang.model.element.NestingKind;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String firstRequest(){
        return "success";
    }
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","你好");
        return "success";
    }
    @RequestMapping("/")
    public String index(){

        return "login";
    }
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String name,
                        @RequestParam("password") String password,
                        Map<String,String> map,
                        HttpSession session){
        if(name.equals("username")&&password.equals("123456")){
            session.setAttribute("user",name);
            return "redirect:/main.html";
        }else {

            map.put("error","登录失败");
            return "login";
        }


    }
}
