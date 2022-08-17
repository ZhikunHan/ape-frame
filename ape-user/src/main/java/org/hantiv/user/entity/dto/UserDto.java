package org.hantiv.user.entity.dto;

import lombok.Data;

/**
 * @Author Zhikun Han
 * @Date Created in 22:06 2022/8/12
 * @Description:
 */
@Data
public class UserDto {

    private String name;

    private Integer age;

    private Integer pageIndex;

    private Integer pageSize;

}
