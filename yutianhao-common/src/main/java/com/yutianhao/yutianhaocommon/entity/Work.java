package com.yutianhao.yutianhaocommon.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @author thyu
 * @title: Work
 * @projectName yutianhao-eureka-jpa-demo
 * @description: TODO
 * @date 2020/7/24 19:40
 */
@Data
@Accessors(chain = true)
@Entity
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String company;

    private String location;

    @Column(name = "work_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date workDate;
}
