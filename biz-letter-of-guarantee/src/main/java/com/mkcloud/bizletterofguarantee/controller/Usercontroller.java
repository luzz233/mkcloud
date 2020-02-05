package com.mkcloud.bizletterofguarantee.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mkcloud.bizletterofguarantee.entity.User;
import com.mkcloud.bizletterofguarantee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lzz
 * @date 2020/1/31 - 0:11
 */
@RestController
@RequestMapping("/user")
public class Usercontroller {

    @Autowired
    private UserService userService;


    @RequestMapping("/saveUser")
    public void saveUser(@RequestBody User user) {
        userService.save(user);
    }

    @RequestMapping("/updateUser")
    public void updateUser(@RequestBody User user) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<User>();
        updateWrapper.eq("username", "lzz");
        user.setNickName("luzhizhong");
        userService.update(updateWrapper);
    }

    @RequestMapping("/removeUser")
    public void removeUser(@RequestBody User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", user.getId());
        userService.remove(queryWrapper);
        userService.removeById(user.getId());
    }

    @RequestMapping("/getOneUser")
    public User getUser(@PathVariable Long id) {
        User user = userService.getById(id);
        return user;
    }


    @RequestMapping("/listUser")
    public List<User> listUser() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", "lzz");
        List<User> userList = userService.list(queryWrapper);
        return userList;
    }

    @RequestMapping("/pageUser")
    public IPage<User> pageUser() {
        IPage<User> page = new Page<>(1, 5);
        IPage<User> userIPage = userService.page(page, null);
        return userIPage;
    }

}
