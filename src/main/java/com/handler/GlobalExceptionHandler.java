package com.handler;

import com.exception.NameException;
import com.exception.PasswordException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = NameException.class)
    public ModelAndView nameException(Exception ex){
        ModelAndView modelAndView=new ModelAndView();
        String view="";
        String msg="";
        if ("注册用户名重复".equals(ex.getMessage())){
            msg="请尝试使用其他用户名";

            view="register";
        }else if(("注册用户名为空").equals(ex.getMessage())){
            msg="请输入用户名";
            view="register";

        }else if(("登录用户名为空").equals(ex.getMessage())){
            msg="请输入用户名";
            view="login";
        }else if ("添加用户名重复".equals(ex.getMessage())){
            msg="请尝试使用其他用户名";

            view="admin";
        }else if(("添加用户名为空").equals(ex.getMessage())){
            msg="请输入用户名";
            view="admin";

        }else if(("删除管理员").equals(ex.getMessage())){
            msg="不允许删除管理员";
            view="admin";

        }
        modelAndView.addObject("msg",msg);
        modelAndView.setViewName(view);
        return modelAndView;
    }
    @ExceptionHandler(value = PasswordException.class)
    public ModelAndView passwordException(Exception ex){
        ModelAndView modelAndView=new ModelAndView();
        String view="";
        String msg="";
        if (("注册密码为空").equals(ex.getMessage())){
            msg="请输入密码";
            view="register";
        }else if(("注册密码小于等于2位").equals(ex.getMessage())){
            msg="请输入的密码大于2位";
            view="register";
        }else if(("登录密码为空").equals(ex.getMessage())){
            msg="请输入密码";
            view="login";
        }else if(("用户密码小于等于2位").equals(ex.getMessage())){
            msg="请输入的密码大于2位";
            view="login";
        }else if(("修改密码为空").equals(ex.getMessage())){
            msg="请输入密码";
            view="update";
        }else if(("修改密码小于等于2位").equals(ex.getMessage())){
            msg="请输入的密码大于2位";
            view="update";
        }else if(("添加密码为空").equals(ex.getMessage())){
            msg="请输入密码";
            view="admin";
        }else if(("添加密码小于等于2位").equals(ex.getMessage())){
            msg="请输入的密码大于2位";
            view="admin";
        }
        modelAndView.addObject("msg",msg);
        modelAndView.setViewName(view);
        return modelAndView;
    }
}
