package com.ujiuye.dao.impl;

import com.ujiuye.dao.CourseDetailDao;
import com.ujiuye.entity.CourseDetail;
import com.ujiuye.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class CourseDetailDaoImpl implements CourseDetailDao {
    QueryRunner qr = JdbcUtil.getQueryRunner();
    @Override
    public int addDetail(CourseDetail cd) {
        int rows = 0;
        String sql = "insert into coursedetail (name,type,url,start_data,cid) values(?,?,?,?,?)";
        try {
            rows = qr.update(sql,cd.getName(),cd.getType(),cd.getUrl(),cd.getStart_data(),cd.getCid());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows;
    }
}
