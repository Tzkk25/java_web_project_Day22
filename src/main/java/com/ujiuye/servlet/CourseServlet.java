package com.ujiuye.servlet;

import com.ujiuye.entity.Course;
import com.ujiuye.service.CourseService;
import com.ujiuye.service.impl.CourseServiceImpl;
import com.ujiuye.util.JsonUtil;
import com.ujiuye.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/courseServlet")
public class CourseServlet extends BaseServlet {
    CourseService cs = new CourseServiceImpl();

    protected void getCourseByCourseName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseName = request.getParameter("courseName");
        String page = request.getParameter("page");
        int rows = Integer.parseInt(request.getParameter("rows"));
        int countRows = cs.getCountRowsByCourseName(courseName);
        System.out.println(countRows);
        PageUtil pu = new PageUtil(page,rows,countRows);
        List<Course> list = cs.getCourseByCourseName(courseName,pu);
        pu.setList(list);
        PrintWriter out = response.getWriter();
        out.print(JsonUtil.toJson(pu));
        out.close();
    }
}