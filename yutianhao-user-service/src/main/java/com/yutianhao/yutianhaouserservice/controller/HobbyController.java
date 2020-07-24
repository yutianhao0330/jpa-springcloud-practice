package com.yutianhao.yutianhaouserservice.controller;

import com.yutianhao.yutianhaocommon.entity.Department;
import com.yutianhao.yutianhaocommon.entity.Hobby;
import com.yutianhao.yutianhaouserservice.service.HobbyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author thyu
 * @title: HobbyController
 * @projectName yutianhao-eureka-jpa-demo
 * @description: TODO
 * @date 2020/7/24 18:02
 */
@Api(value = "爱好的Controller",tags = {"hobby"})
@RestController
@RequestMapping("hobby")
public class HobbyController {
    @Autowired
    private HobbyService hobbyService;
    @ApiOperation(value = "/hobby/list",notes = "爱好查询"
            ,protocols = "http",response = Hobby.class,
            responseContainer = "List",httpMethod = "GET",code = 200
    )
    @ApiResponse(code = 200,message = "所有爱好数据",response = Hobby.class)
    @RequestMapping("list")
    public List<Hobby> list(){
        return hobbyService.list();
    }
}
