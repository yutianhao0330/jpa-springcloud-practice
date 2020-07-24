package com.yutianhao.yutianhaocommon.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author thyu
 * @title: User
 * @projectName yutianhao-eureka-jpa-demo
 * @description: TODO
 * @date 2020/7/23 3:33
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1283433136615932290L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String username;

    private String password;

    @Column(name = "phone")
    private String telephone;

    private Integer gender;//1表示男，0表示女

    private Integer age;

    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String image;

    private Integer state;//1表示正常，0表示禁用

    private String code;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "card_id",referencedColumnName = "id",insertable = true,updatable = true,nullable = true)
    @NotFound(action = NotFoundAction.IGNORE)
    private DriverCard card;

    //多对一，不设置真实外键
    @ManyToOne(cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    @JoinColumn(name = "dept_id",referencedColumnName = "id",insertable = true,updatable = true,nullable = true,
        foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT)
    )
    @NotFound(action = NotFoundAction.IGNORE)
    private Department dept;

    @ManyToMany(cascade = CascadeType.DETACH,fetch = FetchType.LAZY)
    @JoinTable(name = "user_hobby",
        joinColumns = {@JoinColumn(name = "uid",referencedColumnName = "id",foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))},
            inverseJoinColumns = {@JoinColumn(name = "hid",referencedColumnName = "id",foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))},
            uniqueConstraints = @UniqueConstraint(name = "uni_hobby_user",columnNames = {"uid","hid"})
    )
    @NotFound(action = NotFoundAction.IGNORE)
    private List<Hobby> hobbies;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "id",foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    @NotFound(action = NotFoundAction.IGNORE)
    private List<Work> works;
}
