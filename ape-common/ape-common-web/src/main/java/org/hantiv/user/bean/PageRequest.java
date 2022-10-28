package org.hantiv.user.bean;

import lombok.Data;
import lombok.Setter;

/**
 * @Author Zhikun Han
 * @Date Created in 12:37 2022/10/28
 * @Description:
 */
@Setter
public class PageRequest {

    private Long pageNo = 1L;

    private Long pageSize = 10L;

    public Long getPageNo() {
        if (pageNo == null || pageNo < 1){
            return 1L;
        }
        return pageNo;
    }

    public Long getPageSize() {
        if (pageSize == null || pageSize < 1 || pageSize > Integer.MAX_VALUE){
            return 10L;
        }
        return pageSize;
    }
}