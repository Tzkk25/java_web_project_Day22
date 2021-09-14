package com.ujiuye.service.impl;

import com.ujiuye.dao.CourseDetailDao;
import com.ujiuye.dao.impl.CourseDetailDaoImpl;
import com.ujiuye.entity.CourseDetail;
import com.ujiuye.service.CourseDetailService;
import com.ujiuye.util.JsonUtil;
import com.ujiuye.util.ResultUtil;

public class CourseDetailServiceImpl implements CourseDetailService {
    CourseDetailDao cdd = new CourseDetailDaoImpl();
    @Override
    public String addDetail(CourseDetail cd) {
        int rows =cdd.addDetail(cd);
        ResultUtil ru = null;
        if (rows == 0){
            ru = new ResultUtil(0,"添加信息失败",null);
        }else{
            ru = new ResultUtil(1,"添加信息成功",null);
        }
        return JsonUtil.toJson(ru);
    }

}
