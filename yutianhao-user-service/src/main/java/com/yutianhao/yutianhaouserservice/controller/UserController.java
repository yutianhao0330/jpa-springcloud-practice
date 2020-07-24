package com.yutianhao.yutianhaouserservice.controller;

import com.yutianhao.upload.autoconfigure.UploadService;
import com.yutianhao.yutianhaocommon.entity.PageBean;
import com.yutianhao.yutianhaocommon.entity.User;
import com.yutianhao.yutianhaocommon.entity.UserVO;
import com.yutianhao.yutianhaouserservice.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author thyu
 * @title: UserController
 * @projectName yutianhao-eureka-jpa-demo
 * @description: TODO
 * @date 2020/7/23 4:06
 */
@Api(value = "用户的Controller",tags = {"user","MultipartFile"})
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UploadService uploadService;

    @ApiOperation(value = "/user/list",notes = "用户多条件分页查询"
            ,protocols = "http",response = PageBean.class,
            responseContainer = "List",httpMethod = "GET",code = 200
    )
    @ApiResponse(code = 200,message = "返回的用户分页数据",response = PageBean.class)
    @RequestMapping("list")
    public PageBean<User> list(
            @ApiParam(name = "vo",value = "封装查询条件的vo对象",defaultValue = "")
                @RequestBody UserVO vo,
            @ApiParam(name = "current",value = "当前页")
                @RequestParam(defaultValue = "1")Integer current,
            @ApiParam(name = "size",value = "每页条数")
                @RequestParam(defaultValue = "5")Integer size){
        return userService.list(vo,current,size);
    }

    @ApiOperation(value = "/user/save",notes = "保存用户"
            ,protocols = "http",response = Boolean.class,
            httpMethod = "POST",code = 200
    )
    @ApiResponse(code = 200,message = "保存用户是否成功",response = Boolean.class)
    @RequestMapping("save")
    public boolean save(
            @ApiParam(name = "user",value = "要保存的用户对象")
                @RequestBody User user){
        return userService.save(user);
    }

    @ApiOperation(value = "/user/upload",notes = "上传文件"
            ,protocols = "http",response = String.class,
            httpMethod = "POST",code = 200,consumes = "multipart/form-data"
    )
    @ApiResponse(code = 200,message = "上传成功的文件名",response = String.class)
    @RequestMapping("upload")
    public String upload(
            @ApiParam(name = "file",value = "上传的图片")
                @RequestBody MultipartFile file){
        String fileName = "";
        try {
            fileName =  uploadService.upload(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    @ApiOperation(value = "/user/delete",notes = "删除用户"
            ,protocols = "http",response = Boolean.class,
            httpMethod = "GET",code = 200
    )
    @ApiResponse(code = 200,message = "删除用户是否成功",response = Boolean.class)
    @RequestMapping("delete")
    public boolean delete(
            @ApiParam(name = "uids",value = "要删除的所有用户id集合")
                @RequestBody List<Integer> uids){
        return userService.deleteUsers(uids);
    }
}

