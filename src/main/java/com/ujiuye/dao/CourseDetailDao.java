package com.ujiuye.dao;

import com.ujiuye.entity.CourseDetail;

import java.util.List;
import java.util.Map;

public interface CourseDetailDao {
    public int addDetail(CourseDetail cd);
    Map<String, List<CourseDetail>> getDetail(int cid);
}
