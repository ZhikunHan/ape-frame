package org.hantiv.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.hantiv.user.entity.po.UserPo;
import org.springframework.stereotype.Repository;

/**
 * @Author Zhikun Han
 * @Date Created in 21:48 2022/8/12
 * @Description:
 */
@Repository
public interface UserMapper extends BaseMapper<UserPo> {
    IPage<UserPo> getUserPage(IPage<UserPo> userPoPage);
}
