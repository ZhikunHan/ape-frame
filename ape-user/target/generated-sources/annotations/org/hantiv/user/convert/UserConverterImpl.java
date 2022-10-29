package org.hantiv.user.convert;

import javax.annotation.Generated;
import org.hantiv.user.entity.po.User;
import org.hantiv.user.entity.req.UserReq;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-29T16:52:02+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_341 (Oracle Corporation)"
)
public class UserConverterImpl implements UserConverter {

    @Override
    public User convertReqToUser(UserReq userReq) {
        if ( userReq == null ) {
            return null;
        }

        User user = new User();

        return user;
    }
}
