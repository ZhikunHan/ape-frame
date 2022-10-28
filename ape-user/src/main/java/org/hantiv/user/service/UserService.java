package org.hantiv.user.service;


import org.hantiv.user.bean.PageResponse;
import org.hantiv.user.entity.po.User;
import org.hantiv.user.entity.req.UserReq;

/**
 * user(User)表服务接口
 *
 * @author makejava
 * @since 2022-10-28 12:17:45
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Long id);

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @return 查询结果
     */
    PageResponse<User> queryByPage(UserReq userReq);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
