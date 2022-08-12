package org.hantiv.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Zhikun Han
 * @Date Created in 21:22 2022/8/7
 * @Description:
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public String test(){
        return "Hello World";
    }
}
