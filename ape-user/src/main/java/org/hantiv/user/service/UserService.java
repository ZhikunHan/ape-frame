package org.hantiv.user.service;

import org.hantiv.user.entity.dto.UserDto;

/**
 * @Author Zhikun Han
 * @Date Created in 22:05 2022/8/12
 * @Description:
 */
public interface UserService {
    int addUser(UserDto userDto);
}
