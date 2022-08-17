package org.hantiv.user.entity.req;

import lombok.Data;

/**
 * @Author Zhikun Han
 * @Date Created in 8:57 2022/8/17
 * @Description:
 */
@Data
public class UserListReq {

    private Integer pageIndex;

    private Integer pageSize;
}
