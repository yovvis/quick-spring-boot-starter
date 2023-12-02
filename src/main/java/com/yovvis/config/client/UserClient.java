package com.yovvis.config.client;

import com.yovvis.model.entity.User;

/**
 * 客户端配置
 *
 * @author yovvis
 * @date 2023/11/18
 */
public class UserClient {

    /**
     * 用户名称
     */
    private String userName;

    /**
     * accessKey
     */
    private String accessKey;

    private String secretKey;

    public UserClient(String userName, String accessKey, String secretKey) {
        this.userName = userName;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String getUser() {
        return "用户名称：" + userName + "\n\r" + "accessKey：" + accessKey + "\n\r" + "secretKey" + secretKey;
    }

}
