package com.ujiuye.dao.impl;

import com.ujiuye.dao.CourseDao;
import com.ujiuye.entity.Course;
import com.ujiuye.util.JdbcUtil;
import com.ujiuye.util.PageUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
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

    @Override
    public int addCourse(Course c) {
        int rows = 0;
        String sql = "insert into course (courseName,descs,courseType,courseImage,courseVideo,coursePrice,status,createTime)"+
                "values(?,?,?,?,?,?,?,?)";
        try {
            rows = qr.update(sql,c.getCourseName(),c.getDescs(),c.getCourseType(),c.getCourseImage(),c.getCourseVideo(),c.getCoursePrice(),c.getStatus(),c.getCreateTime());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int delAll(String cids) {
        int rows = 0;
        String sql = "delete from course where cid in("+cids+")";
        try {
            rows = qr.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int editCourse(Course c) {
        int rows = 0;
        String sql = "update course set courseName=?,descs=?,courseType=?," +
                "courseImage=?,courseVideo=?,coursePrice=?,status=? where cid=?";
            try {
                rows = qr.update(sql, c.getCourseName(), c.getDescs(), c.getCourseType(), c.getCourseImage(),
                        c.getCourseVideo(),c.getCoursePrice(),c.getStatus(), c.getCid());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return rows;
    }

    @Override
    public Course getCourseByCid(int cid) {
        Course c = null;
        String sql = "select * from course where cid=?";
        try {
            c = qr.query(sql,new BeanHandler<>(Course.class),cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public List<Course> getAllCourse() {
        List<Course> list  = null;
        String sql = "select * from course";
        try {
            list = qr.query(sql,new BeanListHandler<>(Course.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Course> getCourseByType(int courseType, int count) {
        List<Course> list = null;
        String sql = "select * from course where courseType=? limit ?";
        try {
            list = qr.query(sql,new BeanListHandler<>(Course.class),courseType,count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int getCountRows() {
        int countRows = 0;
        String sql = "select count(*) from course";
        try {
            countRows = (int)(long)qr.query(sql,new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countRows;
    }

    @Override
    public List<Course> getCourse(PageUtil pu) {
        List<Course> list = null;
        String sql = "select * from course limit ?,?";
        try {
            list = qr.query(sql,new BeanListHandler<>(Course.class),pu.getIndex(),pu.getRows());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
