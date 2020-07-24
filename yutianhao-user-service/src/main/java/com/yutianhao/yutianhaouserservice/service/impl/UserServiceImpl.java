package com.yutianhao.yutianhaouserservice.service.impl;

import com.yutianhao.yutianhaocommon.entity.DriverCard;
import com.yutianhao.yutianhaocommon.entity.PageBean;
import com.yutianhao.yutianhaocommon.entity.User;
import com.yutianhao.yutianhaocommon.entity.UserVO;
import com.yutianhao.yutianhaouserservice.dao.UserRepository;
import com.yutianhao.yutianhaouserservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author thyu
 * @title: UserServiceImpl
 * @projectName yutianhao-eureka-jpa-demo
 * @description: TODO
 * @date 2020/7/23 3:45
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public PageBean<User> list(UserVO vo, int current, int size) {
        //封装查询条件
        Specification<User> specification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                //根据用户名查询
                if(null!=vo.getUsername() && !"".equals(vo.getUsername())){
                    predicates.add(criteriaBuilder.like(root.get("username"),"%"+vo.getUsername()+"%"));
                }
                //根据电话查询
                if(null!=vo.getTelephone() && !"".equals(vo.getTelephone())){
                    predicates.add(criteriaBuilder.like(root.get("telephone"),"%"+vo.getTelephone()+"%"));
                }
                //根据性别查询
                if(null!=vo.getGender() && vo.getGender()>=0){
                    predicates.add(criteriaBuilder.equal(root.get("gender"),vo.getGender()));
                }
                //根据时间区间查询生日
                if(null!=vo.getMinDate()){
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("birthday"),vo.getMinDate()));
                }
                if(null!=vo.getMaxDate()){
                    predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("birthday"),vo.getMaxDate()));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        PageRequest page = PageRequest.of(current - 1, size, Sort.by(Sort.Direction.DESC,"id"));
        return new PageBean<User>(userRepository.findAll(specification, page));
    }

    @Override
    public boolean save(User user) {
        try{
            userRepository.save(user);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public boolean deleteUsers(List<Integer> uids) {
        try{
            List<Integer> dids = new ArrayList<Integer>();
            for (Integer uid : uids) {
                dids.add(userRepository.findById(uid).get().getCard().getId());
            }
            //删除所有工作信息
            userRepository.deleteWorks(uids);
            //删除所有用户信息
            userRepository.deleteUsers(uids);
            //删除所有驾照信息
            userRepository.deleteDriverCards(dids);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
