package com.yutianhao.yutianhaouserconsumer.service;

import com.yutianhao.yutianhaocommon.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author thyu
 * @title: UserServiceMock
 * @projectName yutianhao-eureka-jpa-demo
 * @description: TODO
 * @date 2020/7/23 4:37
 */
@Component
public class UserServiceMock implements UserService {
    private Logger logger = LoggerFactory.getLogger(UserService.class);
    @Override
    public PageBean<User> list(UserVO vo, Integer current, Integer size) {
        logger.info("发生了熔断..........");
        return null;
    }

    @Override
    public boolean save(User user) {
        return false;
    }

    @Override
    public String upload(MultipartFile file) {
        return null;
    }

    @Override
    public boolean delete(List<Integer> uids) {
        return false;
    }

    @Override
    public List<Department> deptList() {
        return null;
    }

    @Override
    public List<Hobby> hobbyList() {
        return null;
    }

}
