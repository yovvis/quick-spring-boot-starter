package com.yovvis.config;

import com.yovvis.config.client.UserClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 用户客户端配置
 *
 * @author yovvis
 * @date 2023/12/2
 */

@Configuration
@ConfigurationProperties("yovvis.client")
@Data
@ComponentScan
public class UserClientConfig {

    private String userName;

    private String accessKey;

    private String secretKey;

    @Bean
    public UserClient UserClientConfig() {
        return new UserClient(userName, accessKey, secretKey);
    }
}
