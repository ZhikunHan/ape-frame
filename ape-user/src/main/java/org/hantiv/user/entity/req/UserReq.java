package org.hantiv.user.entity.req;

import lombok.Data;
import org.hantiv.user.bean.PageRequest;

import java.io.Serializable;
import java.util.Date;

/**
 * user(User)实体类
 *
 * @author makejava
 * @since 2022-10-28 12:17:44
 */
@Data
public class UserReq extends PageRequest implements Serializable {
    private static final long serialVersionUID = 616015142069596579L;
    /**
     * Primary Key
     */
    private Long id;
    
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

}

