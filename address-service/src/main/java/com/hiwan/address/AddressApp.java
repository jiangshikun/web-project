package com.hiwan.address;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 使用@SpringBootApplication注解标记的类会被spring boot进行加载；
 * 默认会扫描当前类所在包和子包所有配置了spring注解的所有类。
 * 也可以通过scanBasePackages设置扫描的包
 *
 */
@SpringBootApplication
public class AddressApp {

    public static void main(String[] args) {
        SpringApplication.run(AddressApp.class, args);
    }

}
