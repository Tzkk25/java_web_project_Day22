package com.ujiuye.service.impl;

import com.ujiuye.dao.CourseDao;
import com.ujiuye.dao.impl.CourseDaoImpl;
import com.ujiuye.entity.Course;
import com.ujiuye.service.CourseService;
import com.ujiuye.util.JsonUtil;
import com.ujiuye.util.PageUtil;
import com.ujiuye.util.ResultUtil;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    CourseDao cd = new CourseDaoImpl();
    @Override
    public int getCountRowsByCourseName(String courseName) {
        return cd.getCountRowsByCourseName(courseName);
    }

    @Override
    public List<Course> getCourseByCourseName(String courseName, PageUtil pu) {
        return cd.getCourseByCourseName(courseName, pu);
    }

    @Override
    public String addCourse(Course c) {
        int rows = cd.addCourse(c);
        ResultUtil ru = null;
        if (rows == 0){
            ru = new ResultUtil(0,"新增失败",null);
        }else {
            ru = new ResultUtil(1,"新增成功",null);
        }
        return JsonUtil.toJson(ru);
    }

    @Override
    public String delAll(String cids) {
        int rows = cd.delAll(cids);
        ResultUtil ru = null;
        if(rows == 0){
            ru = new ResultUtil(0,"删除失败",null);
        }else{
            ru  = new ResultUtil(1,"删除成功",null);
        }
        return JsonUtil.toJson(ru);
    }

    @Override
    public String editCourse(Course c) {
        int rows = cd.editCourse(c);
        ResultUtil ru = null;
        if(rows == 0){
            ru = new ResultUtil(0,"修改失败",null);
        }else{
            ru = new ResultUtil(1,"修改成功",null);
        }
        return JsonUtil.toJson(ru);
    }

    @Override
    public List<Course> getAllCourse() {
        return cd.getAllCourse();
    }

    @Override
    public List<Course> getCourseByType(int courseType, int count) {
        return cd.getCourseByType(courseType,count);
    }

    @Override
    public int getCountRows() {
        return cd.getCountRows();
    }

    @Override
    public List<Course> getCourse(PageUtil pu) {
        return cd.getCourse(pu);
    }
}
