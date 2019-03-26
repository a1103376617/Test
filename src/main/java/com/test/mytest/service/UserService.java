package com.test.mytest.service;

import com.test.mytest.entity.User;
import com.test.mytest.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;
   //增加修改用户

    public User update(Integer id,User user) throws Exception {

        // service里写业务逻辑
        // 比如当前系统中是否有这个user,或者当前user状态是否允许update
        // 先getById(id) 取出来数据库里的user  DBuser
        User oldUser = userMapper.selectById(id);
        if (oldUser == null) {
            throw new Exception("用户不存在！");
        }
        try {
            userMapper.update(id,user);
            // 在这里抛异常
            System.out.println("修改成功");
        } catch (Exception e) {
            System.out.println("修改失败");


        }

        return oldUser;
    }

    //删除用户
    public boolean del(Integer id) throws Exception {
        User oldUser = userMapper.selectById(id);
        if (oldUser == null) {
            throw new Exception("用户不存在");

        }
        try {
            userMapper.del(id);
            System.out.println("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("删除失败");
        }
        return true;
    }

    //增加用户
    public User insertUser(User user) throws Exception {
        User oldUser = userMapper.selectByName(user.getName());
        if (oldUser != null) {
            throw new Exception("用户已存在");
        }
        try {
            userMapper.insertUser(user);
            System.out.println("添加成功");
        } catch (Exception e) {
            System.out.println("添加失败");

        }
        return null;
    }

    //查询全部用户
    public List<User> selectAllUser(Integer id,String name) {
        //PageHelper.startPage(1,3);
        List<User> list = userMapper.selectAllUser(id,name);
        return list;
    }

    //根据ID查询用户
    public User userById(Integer id) throws Exception {
        User user = userMapper.selectById(id);
        if (user == null) {
            throw new Exception("用户不存在");
        }
        return user;
    }



}
