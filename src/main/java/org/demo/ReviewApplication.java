package org.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReviewApplication {
    // 主启动类，它所在的包及其子包下所有的配置及bean的定义都会被加载
    public static void main(String[] args) {
        SpringApplication.run(ReviewApplication.class, args);
    }
}