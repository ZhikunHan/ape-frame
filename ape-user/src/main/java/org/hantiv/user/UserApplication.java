package org.hantiv.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author Zhikun Han
 * @Date Created in 21:08 2022/8/7
 * @Description:
 */
@SpringBootApplication
@MapperScan("org.hantiv.*.mapper")
@ComponentScan("org.hantiv.*.controller")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class);
    }
}
