package com.ujiuye.dao.impl;

import com.ujiuye.dao.UserDao;
import com.ujiuye.entity.User;
import com.ujiuye.util.JdbcUtil;
import com.ujiuye.util.PageUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    QueryRunner qr = JdbcUtil.getQueryRunner();
    @Override
    public User login(String username, String password) {
        User user = null;
        String sql = "select * from user where username=? and password=?";
        try {
            user = qr.query(sql,new BeanHandler<>(User.class),username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int getCountRows() {
        int countRows = 0;
        String sql = "select count(*) from user";
        try {
            countRows = (int)(long)qr.query(sql,new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countRows;
    }

    @Override
    public List<User> getUserByPage(PageUtil pu) {
        List<User> list = null;
        String sql = "select * from user limit ?,?";
        try {
            list = qr.query(sql,new BeanListHandler<>(User.class),pu.getIndex(),pu.getRows());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int getCountRowsByUsername(String username) {
        int countRows = 0;
        String sql = "select count(*) from user where username like '%"+username+"%'";
        try {
            countRows = (int)(long)qr.query(sql,new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countRows;
    }

    @Override
    public List<User> getUserByUsername(PageUtil pu, String username) {
        List<User> list = null;
        String sql = "select * from user where username like '%"+username+"%' limit ?,?";
        try {
            list = qr.query(sql,new BeanListHandler<>(User.class),pu.getIndex(),pu.getRows());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int addUser(User user) {
        int countRows = 0;
        String sql = "insert into user (name,phone,age,sex,username,password,status,createtime,role) values(?,?,?,?,?,?,?,?,?)";
        try {
            countRows = qr.update(sql,user.getName(),user.getPhone(),user.getAge(),user.getSex(),user.getUsername(),user.getPassword(),user.getStatus(),user.getCreatetime(),user.getRole());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countRows;
    }

    @Override
    public int delAll(String uids) {
        int rows = 0;
        String sql = "delete from user where uid in ("+uids+")";
        try {
            rows = qr.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int editUser(User user) {
        int rows = 0;
        String sql = "update user set name=?,phone=?,age=?,sex=?,username=?,password=?,status=?,role=? where uid=?";
        try {
            rows = qr.update(sql, user.getName(), user.getPhone(), user.getAge(), user.getSex(), user.getUsername(), user.getPassword(),
                    user.getStatus(), user.getRole(), user.getUid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public User getUserByUid(int uid) {
        User u = null;
        String sql = "select * from user where uid=?";
        try {
            u = qr.query(sql,new BeanHandler<>(User.class),uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    @Override
    public User checkPhone(String phone) {
        User user = null;
        String sql = "select * from user where phone=?";
        try {
            user = qr.query(sql,new BeanHandler<>(User.class),phone);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int regist(User user) {
        int rows = 0;
        String sql = "insert into user(name,phone,password,status,createtime,role) values(?,?,?,?,?,?)";
        try {
            rows = qr.update(sql,user.getName(),user.getPhone(),user.getPassword(),user.getStatus(),user.getCreatetime(),user.getRole());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public User userLogin(String phone, String password) {
        User user = null;
        String sql = "select * from user where phone=? and password=?";
        try {
            user = qr.query(sql,new BeanHandler<>(User.class),phone,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}