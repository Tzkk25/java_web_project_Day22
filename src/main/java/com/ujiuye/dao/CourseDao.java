package com.ujiuye.dao;

import com.ujiuye.entity.Course;
import com.ujiuye.util.PageUtil;

import java.util.List;

public interface CourseDao {
    //通过name模糊查询时获取查询到的总信息条数
    public int getCountRowsByCourseName(String courseName);
    //通过name模糊查询时获取查询到的列表
    public List<Course> getCourseByCourseName(String courseName, PageUtil pu);
    //添加课程信息
    public int addCourse(Course c);
    //删除选中的课程信息
    public int delAll(String cids);
    //编辑课程信息
    public int editCourse(Course c);
    //通过id查询课程报名信息分页展示
    public Course getCourseByCid(int cid);
    //用户课程信息展示
    List<Course> getAllCourse();
    //2021-9-13
    //小U课堂信息展示
    List<Course> getCourseByType(int courseType,int count);
    //2021-9-14
    //小U课堂课程详细页面显示(显示所有的课程信息)
    int getCountRows();
    //小U课堂课程详细页面显示(根据分页信息获取对应的课程集合)
    List<Course> getCourse(PageUtil pu);
}
