package com.yutianhao.yutianhaouserconsumer.controller;

import com.yutianhao.yutianhaocommon.entity.Hobby;
import com.yutianhao.yutianhaouserconsumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author thyu
 * @title: HobbyController
 * @projectName yutianhao-eureka-jpa-demo
 * @description: TODO
 * @date 2020/7/24 18:03
 */
@RestController
@RequestMapping("hobby")
public class HobbyController {
    @Autowired
    private UserService userService;
    @RequestMapping("list")
    public List<Hobby> list(){
        return userService.hobbyList();
    }
}
