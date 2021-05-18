package com.controller;

import com.exception.NameException;
import com.exception.PasswordException;
import com.exception.UserException;
import com.po.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
    @GetMapping("/register")
    public String registerPage(){
        return "register";
    }
    @GetMapping("/main")
    public String mainPage(){
        return "main";
    }
    @GetMapping("/update")
    public String updatePage(){
        return "update";
    }
    @GetMapping("/logout")
    public String logout(Model model,HttpSession session){
        session.removeAttribute("user");
        model.addAttribute("msg","已退出登录");
        return "login";
    }
    @PostMapping("/login")
    public String login(User user, Model model, HttpSession session)throws UserException{
        if (user.getName().equals("")){
            throw new NameException("登录用户名为空");
        }
        if (user.getPassword().equals("")){
            throw new PasswordException("登录密码为空");
        }
        if (user.getPassword().length()<=2){
            throw new PasswordException("用户密码小于等于2位");
        }
        if(userService.query(user)!=null){
            session.setAttribute("user",user);
            return "redirect:main";
        }else {
            model.addAttribute("msg","登录失败！");
            return "login";
        }

    }
    @PostMapping("/register")
    public String register(User user,Model model,HttpSession session) throws UserException {
        if (user.getName().equals("")){
            throw new NameException("注册用户名为空");
        }
        if (user.getPassword().equals("")){
            throw new PasswordException("注册密码为空");
        }
        if (userService.queryName(user.getName())!=null){
            throw new NameException("注册用户名重复");
        }
        if (user.getPassword().length()<=2){
            throw new PasswordException("注册密码小于等于2位");
        }
        if(userService.insert(user)==1){
            model.addAttribute("msg","注册成功，请登录");
            return "login";
        }else {
            model.addAttribute("msg","注册失败");
            return "register";
        }
    }
    @PostMapping("/update")
    public String update(User user,Model model,HttpSession httpSession) throws UserException {
        User loginUser=(User)httpSession.getAttribute("user");
        user.setName(loginUser.getName());
        if (user.getPassword().equals("")){
            throw new PasswordException("修改密码为空");
        }
        if (user.getPassword().length()<=2){
            throw new PasswordException("修改密码小于等于2位");
        }
        if(userService.update(user)==1){
            model.addAttribute("msg","修改成功");
            return "main";
        }else{
            model.addAttribute("msg","修改失败");
            return "update";
        }
    }
    @GetMapping("/admin")
    public String adminPage(HttpSession httpSession){
        List<User> list=userService.queryAll();
        httpSession.setAttribute("list",list);
        return "admin";
    }
    @GetMapping("/delete/{name}")
    public String delete(@PathVariable("name") String name,Model model)throws UserException{
        if (name.equals("admin")){
            throw new NameException("删除管理员");
        }
        if(userService.delete(name)==1){
            model.addAttribute("msg","删除成功");

        }else {
            model.addAttribute("msg","删除失败");
        }
        return "redirect:/admin";
    }
    @PostMapping("/addUser")
    public String addUser(User user,Model model) throws UserException{
        if (user.getName().equals("")){
            throw new NameException("添加用户名为空");
        }
        if (user.getPassword().equals("")){
            throw new PasswordException("添加密码为空");
        }
        if (userService.queryName(user.getName())!=null){
            throw new NameException("添加用户名重复");
        }
        if (user.getPassword().length()<=2){
            throw new PasswordException("添加密码小于等于2位");
        }
        if(userService.insert(user)==1){
            model.addAttribute("msg","添加成功");
        }else {
            model.addAttribute("msg","添加失败");
        }
        return "redirect:admin";
    }



}
