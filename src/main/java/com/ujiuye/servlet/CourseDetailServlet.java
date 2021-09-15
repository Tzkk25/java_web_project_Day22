package com.ujiuye.servlet;

import com.ujiuye.entity.CourseDetail;
import com.ujiuye.service.CourseDetailService;
import com.ujiuye.service.impl.CourseDetailServiceImpl;
import com.ujiuye.util.JsonUtil;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/courseDetailServlet")
public class CourseDetailServlet extends BaseServlet {
    CourseDetailService cds = new CourseDetailServiceImpl();
    protected void addDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        Map<String, String[]>map = request.getParameterMap();
        CourseDetail cd = new CourseDetail();
        BeanUtils.populate(cd,map);
        cd.setUrl(cd.getUrl().substring(cd.getUrl().lastIndexOf("/")+1));
        if ("1".equals(cd.getType())){
            cd.setType("第一章");
        }else if("2".equals("第二章")){
            cd.setType("第二章");
        }else {
            cd.setType("第三章");
        }
        String res = cds.addDetail(cd);
        PrintWriter out = response.getWriter();
        out.print(res);
        out.close();
    }

    protected void getDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        int cid = Integer.parseInt(request.getParameter("cid"));
        Map<String, List<CourseDetail>> map = cds.getDetail(cid);
        PrintWriter out = response.getWriter();
        out.print(JsonUtil.toJson(map));
        out.close();
    }

    }
