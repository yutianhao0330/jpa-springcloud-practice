package com.yutianhao.yutianhaocommon.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author thyu
 * @title: Hobby
 * @projectName yutianhao-eureka-jpa-demo
 * @description: TODO
 * @date 2020/7/24 17:54
 */
@Data
@Accessors(chain = true)
@Entity
public class Hobby implements Serializable {
    private static final long serialVersionUID = 3845925345663818974L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20)
    private String name;

    @Column(length = 50)
    private String description;
}
