package com.test.mytest.mapper;

import com.test.mytest.entity.User;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public interface UserMapper {


    User selectById(Integer id);

    User selectByName(String name);

    void insertUser(User user);

    List<User> selectAllUser(@Param("id") Integer id,@Param("name") String name);

    void del(Integer id);




    void update(@Param("id") Integer id, @Param("user") User user);
}