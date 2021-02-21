package com.lxq.api.controller;


import com.lxq.api.entity.po.User;
import com.lxq.api.service.UserService;
import com.lxq.api.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@RestController
@CrossOrigin   //解决跨域
@RequestMapping("api/user/") //提供一个访问地址
public class UserController {

    //注入
    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    //用户的注册
    @PostMapping("AddUser")
    public Map AddUser(User user){

        Map map = new HashMap();

        //获取用户输入的账号 根据账号查询
        String name = user.getName();

        //查询
       User user1=userService.queryUser(name);


       //如果相等 账号已存在
        if(user1!=null){


            if(!user1.getName().equals(name)){

                //获取用户输入到密码 和数据库的进行对比
                String password = user.getPassword();

                if(!user1.getPassword().equals(password)){

                    //然后新增用户
                    userService.addUser(user);
                    map.put("code",400);
                    map.put("message","注册成功");

                }else{
                    //密码已存在
                    map.put("code",200);
                    map.put("message","密码已存在");
                }

            }else{

                    map.put("code",300);
                    map.put("message","账号已存在");

            }


        }



        if(user1==null){

            //加密密码
            String md5Password = MD5Util.MD5Encode(user.getPassword() + user.getName());
            user.setPassword(md5Password);
            //然后新增用户
            userService.addUser(user);
            map.put("message","注册成功");
            map.put("code",100);
        }
        return map;
    }


    //用户的登录
    @GetMapping("loginUser")
    public Map loginUser(String username,String password){

        //创建map
        Map map = new HashMap();

        //根据用户输入的账号查询
        User user=userService.queryUserByName(username);

        if(user!=null){

            //加密 进行对比
            String md5password = MD5Util.MD5Encode(password + username);

            if(user.getPassword().equals(md5password)){

                //将数据放到session中
                request.getSession().setAttribute("loginName",user);
                //登录成功
                map.put("code",300);
                map.put("message","登录成功");
            }else{
                //密码不正确
                map.put("code",200);
                map.put("message","密码错误");
            }
        }else{
            map.put("code",100);
            map.put("message","账号不存在");
        }

        return map;
    }

}
