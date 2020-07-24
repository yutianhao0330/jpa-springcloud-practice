package com.yutianhao.yutianhaouserservice.dao;

import com.yutianhao.yutianhaocommon.entity.DriverCard;
import com.yutianhao.yutianhaocommon.entity.PageBean;
import com.yutianhao.yutianhaocommon.entity.User;
import com.yutianhao.yutianhaocommon.entity.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author thyu
 * @title: UserRepository
 * @projectName yutianhao-eureka-jpa-demo
 * @description: TODO
 * @date 2020/7/23 3:44
 */
public interface UserRepository extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User>{

    @Query(" delete from User where id in :uids")
    @Modifying
    Integer deleteUsers(List<Integer> uids);

    @Query(" delete from DriverCard where id in :ids")
    @Modifying
    Integer deleteDriverCards(List<Integer> ids);

    @Query(nativeQuery = true,value = "delete from work where user_id in :ids")
    @Modifying
    Integer deleteWorks(List<Integer> ids);

}
