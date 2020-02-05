package com.mkcloud.bizletterofguarantee.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author lzz
 * @date 2020/1/30 - 23:48
 */
@Data
public class User {
    @TableId(type= IdType.AUTO)
    private Long id;
    private String username;
    private String nickName;
    private String sex;
    private String email;
    private String phone;
    private Boolean enabled;
    private String password;
    private Timestamp createTime;
    private Date lastPasswordResetTime;

}
