package com.yutianhao.yutianhaouserconsumer.service;

import com.yutianhao.yutianhaocommon.entity.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author thyu
 * @title: UserService
 * @projectName yutianhao-eureka-jpa-demo
 * @description: TODO
 * @date 2020/7/23 4:22
 */
@FeignClient(name = "user-service",fallback = UserServiceMock.class)
public interface UserService {
    @RequestMapping("/user/list")
    PageBean<User> list(@RequestBody UserVO vo, @RequestParam("current")Integer current,@RequestParam("size")Integer size);
    @RequestMapping("/user/save")
    boolean save(@RequestBody User user);
    @RequestMapping(value = "/user/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String upload(@RequestBody MultipartFile file);
    @RequestMapping("/user/delete")
    boolean delete(@RequestBody List<Integer> uids);
    @RequestMapping("/dept/list")
    List<Department> deptList();
    @RequestMapping("/hobby/list")
    List<Hobby> hobbyList();
}
