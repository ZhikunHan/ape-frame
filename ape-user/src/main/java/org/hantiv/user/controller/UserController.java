package org.hantiv.user.controller;

import org.hantiv.bean.Result;
import org.hantiv.user.entity.dto.UserDto;
import org.hantiv.user.entity.req.UserListReq;
import org.hantiv.user.entity.req.UserReq;
import org.hantiv.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Zhikun Han
 * @Date Created in 22:13 2022/8/12
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public Integer addUser(@RequestBody UserReq userReq){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userReq, userDto);
        int i = userService.addUser(userDto);
        return i;
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.ok(userService.delete(id));
    }

    @GetMapping
    public Result getPage(@RequestBody UserListReq userListReq) {
        UserDto userDto = new UserDto();
        System.out.println(userListReq.toString());
        BeanUtils.copyProperties(userListReq, userDto);
        return Result.ok(userService.getUserPage(userDto));
    }
}
