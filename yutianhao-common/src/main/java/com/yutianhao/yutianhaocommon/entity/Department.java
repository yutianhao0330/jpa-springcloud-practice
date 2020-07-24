package com.yutianhao.yutianhaocommon.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author thyu
 * @title: Department
 * @projectName yutianhao-eureka-jpa-demo
 * @description: TODO
 * @date 2020/7/24 8:22
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "dept")
public class Department implements Serializable {

    private static final long serialVersionUID = 1650010732035947016L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;


}
