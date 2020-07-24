package com.yutianhao.yutianhaouserconsumer.controller;

import com.yutianhao.yutianhaouserconsumer.service.UserService;
import com.yutianhao.yutianhaocommon.entity.PageBean;
import com.yutianhao.yutianhaocommon.entity.User;
import com.yutianhao.yutianhaocommon.entity.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author thyu
 * @title: UserController
 * @projectName yutianhao-eureka-jpa-demo
 * @description: TODO
 * @date 2020/7/23 4:24
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("list")
    public PageBean<User> list(UserVO vo, @RequestParam(defaultValue = "1")Integer current,@RequestParam(defaultValue = "5")Integer size){
        return userService.list(vo,current,size);
    }
    @RequestMapping("save")
    public boolean save(@RequestBody User user){
        System.err.println(user);
        return userService.save(user);
    }
    @RequestMapping(value = "upload")
    public String upload(@RequestBody MultipartFile file){
        return userService.upload(file);
    }
    @RequestMapping("delete")
    public boolean delete(String uids){
        List<Integer> uidsList = new ArrayList<>();
        if(!uids.isEmpty() && uids.split(",").length>0){
            for (String uid : uids.split(",")) {
                uidsList.add(Integer.parseInt(uid));
            }
        }
        return userService.delete(uidsList);
    }
}
