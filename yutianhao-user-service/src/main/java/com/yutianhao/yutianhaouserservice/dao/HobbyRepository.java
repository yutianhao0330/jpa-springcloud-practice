package com.yutianhao.yutianhaouserservice.dao;

import com.yutianhao.yutianhaocommon.entity.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author thyu
 * @title: HobbyRepository
 * @projectName yutianhao-eureka-jpa-demo
 * @description: TODO
 * @date 2020/7/24 17:58
 */
public interface HobbyRepository extends JpaRepository<Hobby,Integer> {

}
