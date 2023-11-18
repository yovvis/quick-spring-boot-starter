package com.bululu.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 客户端配置
 *
 * @author yovvis
 * @date 2023/11/18
 */
@Configuration
@ConfigurationProperties("bululu.client")
@Data
@ComponentScan
public class ClientConfig {

    private String accessKey;

    private String secretKey;

}
