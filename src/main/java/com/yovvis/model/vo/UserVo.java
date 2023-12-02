package com.yovvis.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户视图
 *
 * @author yovvis
 * @date 2023/12/2
 */
@Data
public class UserVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 用户角色
     */
    private String userRole;
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
