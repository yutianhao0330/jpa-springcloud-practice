package com.yutianhao.yutianhaouserservice.controller;

import com.yutianhao.yutianhaocommon.entity.Department;
import com.yutianhao.yutianhaocommon.entity.Hobby;
import com.yutianhao.yutianhaocommon.entity.PageBean;
import com.yutianhao.yutianhaouserservice.service.DeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author thyu
 * @title: DeptController
 * @projectName yutianhao-eureka-jpa-demo
 * @description: TODO
 * @date 2020/7/24 8:33
 */
@Api(value = "部门的Controller",tags = {"dept"})
@RestController
@RequestMapping("dept")
public class DeptController {
    @Autowired
    private DeptService deptService;
    @ApiOperation(value = "/dept/list",notes = "部门查询"
            ,protocols = "http",response = Department.class,
            responseContainer = "List",httpMethod = "GET",code = 200
    )
    @ApiResponse(code = 200,message = "所有部门数据",response = Department.class)
    @RequestMapping("list")
    public List<Department> list(){
        return deptService.list();
    }
}
