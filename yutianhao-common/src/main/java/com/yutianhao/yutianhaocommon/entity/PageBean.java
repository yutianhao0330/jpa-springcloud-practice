package com.yutianhao.yutianhaocommon.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

/**
 * @author thyu
 * @title: PageBean
 * @projectName yutianhao-eureka-jpa-demo
 * @description: TODO
 * @date 2020/7/23 3:38
 */
@Data
@Accessors(chain = true)
public class PageBean<T> implements Serializable {

    private static final long serialVersionUID = -2858729972442841202L;
    private List<T> records;
    private Integer current;
    private Integer size;
    private Long total;
    private Integer pages;

    public PageBean(Page<T> page) {
        this.records = page.getContent();
        this.current = page.getNumber()+1;
        this.size = page.getSize();
        this.total = page.getTotalElements();
        this.pages = page.getTotalPages();
    }

    public PageBean(){

    }
}
