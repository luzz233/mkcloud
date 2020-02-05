package com.mkcloud.bizletterofguarantee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mkcloud.bizletterofguarantee.entity.User;
import com.mkcloud.bizletterofguarantee.mapper.UserMapper;
import com.mkcloud.bizletterofguarantee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lzz
 * @date 2020/1/31 - 15:23
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;
}
