package com.ujiuye.service;

import com.ujiuye.entity.CourseUser;
import com.ujiuye.util.PageUtil;

import java.util.List;

public interface CourseUserService {
    int getCountRowsByName(String name);

    List<CourseUser> getByName(String name, PageUtil pu);

    String delAll(String ids);

    String editCourseUser(int id,int cid);

}
