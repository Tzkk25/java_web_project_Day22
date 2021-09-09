package com.ujiuye.dao;

import com.ujiuye.entity.Course;
import com.ujiuye.util.PageUtil;

import java.util.List;

public interface CourseDao {
    public int getCountRowsByCourseName(String courseName);

    public List<Course> getCourseByCourseName(String courseName, PageUtil pu);
}
