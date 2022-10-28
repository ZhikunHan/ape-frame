package org.hantiv.user.service.impl;


import org.hantiv.user.bean.PageResponse;
import org.hantiv.user.convert.UserConverter;
import org.hantiv.user.entity.po.User;
import org.hantiv.user.dao.UserDao;
import org.hantiv.user.entity.req.UserReq;
import org.hantiv.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * user(User)表服务实现类
 *
 * @author makejava
 * @since 2022-10-28 12:17:46
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Long id) {
        return this.userDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param userReq 筛选条件
     * @return 查询结果
     */
    @Override
    public PageResponse<User> queryByPage(UserReq userReq) {
        User user = UserConverter.INSTANCE.convertReqToUser(userReq);
        PageResponse<User> pageResponse = new PageResponse<>();
        pageResponse.setCurrent(userReq.getPageNo());
        pageResponse.setPageSize(userReq.getPageSize());
        Long pageStart = (userReq.getPageNo() -1)* userReq.getPageSize();
        long total = this.userDao.count(user);
        List<User> userList = this.userDao.queryAllByLimit(user, pageStart, userReq.getPageSize());
        pageResponse.setTotal(total);
        pageResponse.setRecords(userList);
        return pageResponse;
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.userDao.deleteById(id) > 0;
    }
}
