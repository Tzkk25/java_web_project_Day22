package com.ujiuye.dao.impl;

import com.ujiuye.dao.CourseDetailDao;
import com.ujiuye.entity.CourseDetail;
import com.ujiuye.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<String, List<CourseDetail>> getDetail(int cid) {
        Map<String, List<CourseDetail>> map = new HashMap<>();
        List<String> list = null;
        String sql1 = "select distinct type from courseDetail where cid=?";
        try {
            //获取指定课程所有章节
            list = (List<String>) qr.query(sql1,new ColumnListHandler(),cid);
            //根据章节和课程id获取该章节的详细信息
            List<CourseDetail> cdList = null;
            String sql2 = "select * from courseDetail where cid=? and type=?";
            for (String s:list){
                cdList = qr.query(sql2,new BeanListHandler<>(CourseDetail.class),cid,s);
                map.put(s,cdList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }
}
