package com.yovvis.model.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户
 *
 * @author yovvis
 * @date 2023/12/2
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;
    /**
     * 用户账号
     */
    private String account;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户角色
     */
    private String userRole;
    /**
     * 密文密码
     */
    private String password;
    /**
     * accessKey
     */
    private String accessKey;
    /**
     * secretKey
     */
    private String secretKey;
    /**
     * 用户头像
     */
    private String userAvatar;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 性别
     */
    private String gender;
}
