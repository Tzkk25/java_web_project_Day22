package com.ujiuye.service.impl;

import com.ujiuye.dao.CourseUserDao;
import com.ujiuye.dao.impl.CourseUserDaoImpl;
import com.ujiuye.entity.CourseUser;
import com.ujiuye.service.CourseUserService;
import com.ujiuye.util.JsonUtil;
import com.ujiuye.util.PageUtil;
import com.ujiuye.util.ResultUtil;

import java.util.List;

public class CourseUserServiceImpl implements CourseUserService {
    CourseUserDao cud = new CourseUserDaoImpl();

    @Override
    public int getCountRowsByName(String name) {
        return cud.getCountRowsByName(name);
    }

    @Override
    public List<CourseUser> getByName(String name, PageUtil pu) {
        return cud.getByName(name,pu);
    }

    @Override
    public String delAll(String ids) {
        int rows = cud.delAll(ids);
        ResultUtil ru = null;
        if (rows == 0){
            ru = new ResultUtil(0,"删除课程信息失败",null);
        }else{
            ru = new ResultUtil(1,"删除课程信息成功",null);
        }
        return JsonUtil.toJson(ru);
    }

    @Override
    public String editCourseUser(int id, int cid) {
        int rows = cud.editCourseUser(cid,id);
        ResultUtil ru = null;
        if (rows == 0){
            ru = new ResultUtil(0,"修改失败",null);
        }else{
            ru = new ResultUtil(1,"修成成功",null);
        }
        return JsonUtil.toJson(ru);
    }
}
