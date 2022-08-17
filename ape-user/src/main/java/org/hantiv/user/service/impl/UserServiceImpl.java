package org.hantiv.user.service.impl;

import org.hantiv.user.entity.dto.UserDto;
import org.hantiv.user.entity.po.UserPo;
import org.hantiv.user.mapper.UserMapper;
import org.hantiv.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Zhikun Han
 * @Date Created in 22:09 2022/8/12
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(UserDto userDto) {
        UserPo userPo = new UserPo();
        BeanUtils.copyProperties(userDto, userPo);
        int count = userMapper.insert(userPo);
        return count;
    }
}
