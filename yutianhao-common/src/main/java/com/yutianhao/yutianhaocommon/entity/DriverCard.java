package com.yutianhao.yutianhaocommon.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author thyu
 * @title: DriverCard
 * @projectName yutianhao-eureka-jpa-demo
 * @description: TODO
 * @date 2020/7/24 5:47
 */
@Data
@Accessors(chain = true)
@Entity
public class DriverCard implements Serializable {

    private static final long serialVersionUID = -4248810433969742308L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "card_no")
    private String cardNo;

    @Column(name = "card_type")
    private String cardType;

    @Column(name = "limit_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String limitDate;
}
