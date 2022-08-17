package org.hantiv.user.service;

import org.hantiv.entity.PageResult;
import org.hantiv.user.entity.dto.UserDto;
import org.hantiv.user.entity.po.UserPo;

/**
 * @Author Zhikun Han
 * @Date Created in 22:05 2022/8/12
 * @Description:
 */
public interface UserService {
    int addUser(UserDto userDto);

    int delete(Integer id);

    PageResult<UserPo> getUserPage(UserDto userDto);
}
