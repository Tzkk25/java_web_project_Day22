package com.ujiuye.service;

import com.ujiuye.entity.CourseDetail;

import java.util.List;
import java.util.Map;

public interface CourseDetailService {
    public String addDetail(CourseDetail cd);
    public Map<String, List<CourseDetail>> getDetail(int cid);
}
