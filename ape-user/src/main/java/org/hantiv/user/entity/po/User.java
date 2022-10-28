package org.hantiv.user.entity.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import java.util.Date;
import java.io.Serializable;

/**
 * user(User)实体类
 *
 * @author makejava
 * @since 2022-10-28 12:17:44
 */
@ApiModel
public class User implements Serializable {
    private static final long serialVersionUID = 616015142069596579L;
    /**
     * Primary Key
     */
    private Long id;

    @ApiModelProperty("名称")
    private String name;
    
    private Integer age;
    
    private String createBy;
    /**
     * Create Time
     */
    private Date createTime;
    
    private String updateBy;
    /**
     * Update Time
     */
    private Date updateTime;
    
    private Integer deleteFlag;
    
    private Integer version;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}

