package org.hantiv.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.hantiv.user.bean.PageResponse;
import org.hantiv.user.bean.Result;
import org.hantiv.user.entity.po.User;
import org.hantiv.user.entity.req.UserReq;
import org.hantiv.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * user(User)表控制层
 *
 * @author makejava
 * @since 2022-10-28 12:17:41
 */
@RestController
@RequestMapping("user")
@Api(tags = "用户Controller")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 分页查询
     * @return 查询结果
     */
    @GetMapping
    public Result<PageResponse<User>> queryByPage(UserReq userReq) {
        return Result.ok(this.userService.queryByPage(userReq));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public Result<User> queryById(@PathVariable("id") Long id) {
        return Result.ok(this.userService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation(value = "新增用户", notes = "用户数据")
    public Result<User> add( @ApiParam("用户类") User user) {
        return Result.ok(this.userService.insert(user));
    }

    /**
     * 编辑数据
     *
     * @param user 实体
     * @return 编辑结果
     */
    @PutMapping
    public Result<User> edit(User user) {
        return Result.ok(this.userService.update(user));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public Result deleteById(Long id) {
        return Result.ok(this.userService.deleteById(id));
    }

}

