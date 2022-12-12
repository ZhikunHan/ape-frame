package org.hantiv.user.convert;

import org.hantiv.user.entity.po.User;
import org.hantiv.user.entity.req.UserReq;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author Zhikun Han
 * @Date Created in 21:00 2022/10/28
 * @Description:
 */
@Mapper
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    User convertReqToUser(UserReq userReq);

}
