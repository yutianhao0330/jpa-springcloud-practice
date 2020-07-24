package com.yutianhao.yutianhaouserservice.service;

import com.yutianhao.yutianhaocommon.entity.PageBean;
import com.yutianhao.yutianhaocommon.entity.User;
import com.yutianhao.yutianhaocommon.entity.UserVO;

import java.util.List;

/**
 * @author thyu
 * @title: UserService
 * @projectName yutianhao-eureka-jpa-demo
 * @description: TODO
 * @date 2020/7/23 3:45
 */
public interface UserService {
    /**
     * 分页多条件查询
     * @param vo
     * @param current
     * @param size
     * @return
     */
    PageBean<User> list(UserVO vo, int current, int size);

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    boolean save(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    boolean deleteUsers(List<Integer> uids);
}
