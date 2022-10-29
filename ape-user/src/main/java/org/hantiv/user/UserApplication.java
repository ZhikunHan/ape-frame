package org.hantiv.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author Zhikun Han
 * @Date Created in 21:08 2022/8/7
 * @Description:
 */
@SpringBootApplication
@MapperScan(value = "org.hantiv.*.dao")
@ComponentScan(value = "org.hantiv")
@EnableCaching
public class UserApplication {
    public static void main(String[] args) {
        System.setProperty("Log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
        SpringApplication.run(UserApplication.class);
    }
}
