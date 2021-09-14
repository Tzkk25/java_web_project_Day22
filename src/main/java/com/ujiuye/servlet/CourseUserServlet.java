package com.ujiuye.servlet;

import com.ujiuye.entity.CourseUser;
import com.ujiuye.service.CourseUserService;
import com.ujiuye.service.impl.CourseUserServiceImpl;
import com.ujiuye.util.JsonUtil;
import com.ujiuye.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.PrinterGraphics;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/courseUserServlet")
public class CourseUserServlet extends BaseServlet {

    CourseUserService cus = new CourseUserServiceImpl();
    //通过搜索名字实现分页
    protected void getByUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String page = request.getParameter("page");
        int rows = Integer.parseInt(request.getParameter("rows"));
        int countRows = cus.getCountRowsByName(name);
        PageUtil pu  = new PageUtil(page,rows,countRows);
        List<CourseUser> list = cus.getByName(name,pu);
        pu.setList(list);
        PrintWriter out = response.getWriter();
        out.print(JsonUtil.toJson(pu));
        out.close();
    }

    //根据指定id索引删除信息
    protected void delAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ids = request.getParameter("ids");
        String res = cus.delAll(ids);
        PrintWriter out = response.getWriter();
        out.print(res);
        out.close();
    }

    //管理课表的信息展示
    protected void editCourseUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int cid = Integer.parseInt(request.getParameter("cid"));
        String res = cus.editCourseUser(id,cid);
        PrintWriter out = response.getWriter();
        out.print(res);
        out.close();
    }

}