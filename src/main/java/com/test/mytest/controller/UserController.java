package com.test.mytest.controller;

import com.test.mytest.entity.User;
import com.test.mytest.service.UserService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.util.StringUtil;

import javax.transaction.Transactional;
import java.lang.reflect.Method;
import java.util.List;

@RestController

public class UserController {
    @Autowired
    private UserService userService;
    private User user;

    //增加用户
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String insert(@RequestBody User user) throws Exception {
        if (StringUtil.isEmpty(user.getName())) {
            throw new Exception("姓名不能为空！");


        }

        userService.insertUser(user);

        String str = "添加成功";
        return str;
    }

    //修改用户

    @RequestMapping (value ="/update",method = RequestMethod.POST)
    public User update(@RequestParam("id") Integer id, @RequestBody User user) throws Exception {

        if (StringUtil.isEmpty(user.getName())) {
            throw new Exception("姓名不能为空！");
        }

        User newUser = userService.update(id,user);
        return newUser;
    }

    //查询所有的用户
    @ResponseBody
    @GetMapping (value = "/user")
    public List<User> getAllUser(@RequestParam("id") Integer id, @RequestParam("name") String name) {
        List<User> list = userService.selectAllUser(id,name);

        return list;
    }

    //删除用户
    @Transactional
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public String del(@PathVariable("id") Integer id) throws Exception {

        userService.del(id);


        String str = "删除成功";
        return str;
    }

    //根据ID查询用户
    @RequestMapping(value = "/userd/{id}", method = RequestMethod.GET)
    public User userById(@PathVariable("id") Integer id) throws Exception {
        User user = userService.userById(id);
        return user;
    }
}


