package com.ujiuye.service.impl;

import com.ujiuye.dao.CourseDao;
import com.ujiuye.dao.impl.CourseDaoImpl;
import com.ujiuye.entity.Course;
import com.ujiuye.service.CourseService;
import com.ujiuye.util.PageUtil;

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
}
