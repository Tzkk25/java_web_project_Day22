package com.ujiuye.dao.impl;

import com.ujiuye.dao.CourseDao;
import com.ujiuye.dao.CourseUserDao;
import com.ujiuye.dao.UserDao;
import com.ujiuye.entity.Course;
import com.ujiuye.entity.CourseUser;
import com.ujiuye.entity.User;
import com.ujiuye.util.JdbcUtil;
import com.ujiuye.util.PageUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class CourseUserDaoImpl implements CourseUserDao {
    QueryRunner qr = JdbcUtil.getQueryRunner();
    CourseDao cd = new CourseDaoImpl();
    UserDao ud = new UserDaoImpl();
    @Override
    public int getCountRowsByName(String name) {
        int countRows = 0;
        String sql = "select count(*) from course_user c,user u where c.uid=u.uid and u.name like '%"+name+"%'";
        try {
            countRows = (int)(long)qr.query(sql,new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countRows;
    }

    @Override
    public List<CourseUser> getByName(String name, PageUtil pu) {
        List<CourseUser> list = null;
        String sql = "select * from course_user c,user u where c.uid = u.uid and u.name like '%"+name+"%' limit ?,?";
        try {
            list = qr.query(sql,new BeanListHandler<>(CourseUser.class),pu.getIndex(),pu.getRows());
            for (CourseUser cu : list){
                int cid = cu.getCid();
                Course course = cd.getCourseByCid(cid);
                cu.setCourse(course);
                int uid = cu.getUid();
                User user = ud.getUserByUid(uid);
                cu.setUser(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int delAll(String ids) {
        int rows = 0;
        String sql ="delete from course_user where id in("+ids+")";
        try {
            rows = qr.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int editCourseUser(int id, int cid) {
        int rows = 0;
        String sql = "update course_user set cid=? where id=?";
        try {
            rows = qr.update(sql,cid,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }
}
