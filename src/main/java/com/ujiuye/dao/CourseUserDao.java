package com.ujiuye.dao;

import com.ujiuye.entity.CourseUser;
import com.ujiuye.util.PageUtil;

import java.util.List;

public interface CourseUserDao {
    public int getCountRowsByName(String name);

    public List<CourseUser> getByName(String name, PageUtil pu);

    public int delAll(String ids);

    public int editCourseUser(int id,int cid);
}
