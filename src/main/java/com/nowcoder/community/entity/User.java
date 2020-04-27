package com.nowcoder.community.entity;

import lombok.Data;

import java.util.Date;

/**
 * className:User
 * Package:
 * Description
 *
 * @Date:
 * @Author:736354146@qq.com
 */
@Data
public class User {
    //编号
    private int id;
    //用户名
    private String username;
    //密码
    private String password;
    private String salt;
    //邮箱
    private String email;
    //类型
    private int type;
    //状态
    private int status;
    //激活码
    private String activationCode;
    private String headerUrl;
    //创建时间
    private Date createTime;
}
