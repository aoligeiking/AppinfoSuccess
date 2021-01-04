package com.app.controller;

import com.app.pojo.DevUser;
import com.app.util.EmptyUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DevLoginController {

    @RequestMapping(value = "/dev/login")
    public String devLogin(){
        return "devlogin";
    }

    @RequestMapping(value = "dologin",method = RequestMethod.POST)
    public String doLogin(@RequestParam(required = true) String devCode,@RequestParam String devPassword){
        //1.进行用户名和密码的判空
        if (EmptyUtils.isNotEmpty(devCode) && EmptyUtils.isNotEmpty(devPassword)){
          DevUser devUser= devService.doLogin(devCode,devPassword);
          if (EmptyUtils.isNotEmpty(devUser)){
              request.getSession().setAttribute("devUserSession",devUser);
              return "redirect:/WEB-INF/jsp/developer/main.jsp";
          }else{
              request.setAttribute("error","用户名或者密码错误");
          }
        }else{
            request.setAttribute("error","用户名或者密码不能为空");

        }
        return "devlogin";
    }

}
