package com.ujiuye.service;

import com.ujiuye.entity.Course;
import com.ujiuye.util.PageUtil;

import java.util.List;

public interface CourseService {
    public int getCountRowsByCourseName(String courseName);

    public List<Course> getCourseByCourseName(String courseName, PageUtil pu);

    public String addCourse(Course c);

    public String delAll(String cids);

    public String editCourse(Course c);

    public List<Course> getAllCourse();

    public List<Course> getCourseByType(int courseType,int count);

    //小U课堂课程详情页面的显示
    public int getCountRows(String courseType, String courseName);

    //小U课堂课程详情分页的显示
    public List<Course> getCourse(PageUtil pu, String courseType, String courseName);

    public Course getCourseByCid(int cid);
}
