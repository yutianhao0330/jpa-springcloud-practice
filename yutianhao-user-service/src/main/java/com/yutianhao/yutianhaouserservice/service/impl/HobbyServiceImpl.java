package com.yutianhao.yutianhaouserservice.service.impl;

import com.yutianhao.yutianhaocommon.entity.Hobby;
import com.yutianhao.yutianhaouserservice.dao.HobbyRepository;
import com.yutianhao.yutianhaouserservice.service.HobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author thyu
 * @title: HobbyServiceImpl
 * @projectName yutianhao-eureka-jpa-demo
 * @description: TODO
 * @date 2020/7/24 18:01
 */
@Service
public class HobbyServiceImpl implements HobbyService {
    @Autowired
    private HobbyRepository hobbyRepository;

    @Override
    public List<Hobby> list() {
        return hobbyRepository.findAll();
    }
}
