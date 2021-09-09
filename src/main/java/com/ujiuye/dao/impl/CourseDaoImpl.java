package com.ujiuye.dao.impl;

import com.ujiuye.dao.CourseDao;
import com.ujiuye.entity.Course;
import com.ujiuye.util.JdbcUtil;
import com.ujiuye.util.PageUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class CourseDaoImpl implements CourseDao {
    QueryRunner qr = JdbcUtil.getQueryRunner();
    @Override
    public int getCountRowsByCourseName(String courseName) {
        int countRows = 0;
        String sql = "select count(*) from course where courseName like '%"+courseName+"%'";
        try {
            countRows = (int)(long)qr.query(sql,new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countRows;
    }

    @Override
    public List<Course> getCourseByCourseName(String courseName, PageUtil pu) {
        List<Course> list = null;
        String sql = "select * from course where courseName like '%"+courseName+"%' limit ?,?";
        try {
            list = qr.query(sql,new BeanListHandler<>(Course.class),pu.getIndex(),pu.getRows());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
