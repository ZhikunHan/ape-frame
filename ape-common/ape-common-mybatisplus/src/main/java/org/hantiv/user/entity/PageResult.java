package org.hantiv.user.entity;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @Author Zhikun Han
 * @Date Created in 10:03 2022/8/14
 * @Description:
 */
@Data
public class PageResult<T> implements Serializable {

    private Long total;

    private Long size;

    private Long current;

    private Long pages;

    private List<T> records = Collections.emptyList();

    public void loadData(IPage<T> pageData){
        this.setCurrent(pageData.getCurrent());
        this.setPages(pageData.getPages());
        this.setSize(pageData.getSize());
        this.setTotal(pageData.getTotal());
        this.setRecords(pageData.getRecords());
    }
}
