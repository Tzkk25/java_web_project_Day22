package com.ujiuye.servlet;

import com.ujiuye.entity.User;
import com.ujiuye.service.UserService;
import com.ujiuye.service.impl.UserServiceImpl;
import com.ujiuye.util.JsonUtil;
import com.ujiuye.util.PageUtil;
import com.ujiuye.util.ResultUtil;
import com.ujiuye.util.VerifyCodeUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet("/userServlet")
public class UserServlet extends BaseServlet {
    UserService us = new UserServiceImpl();

    protected void createCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //生成随机字符串 长度为4
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        //存入会话Session
        HttpSession session = request.getSession();
        //在存入会话之前需要把之前Session存放的图片删除掉
        session.removeAttribute("verCode");
        session.setAttribute("verCode", verifyCode);
        //生成新的图片
        int w = 100, h = 30;
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String code = request.getParameter("code");
        HttpSession session = request.getSession();
        String res = us.login(username, password, code, session);
        PrintWriter out = response.getWriter();
        out.print(res);
        out.close();
    }

    protected void getUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        PrintWriter out = response.getWriter();
        out.print(JsonUtil.toJson(user));
        out.close();
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //无论Session中有什么信息都将其终结掉
        session.invalidate();
        ResultUtil ru = new ResultUtil(1, "退出登录成功", null);
        PrintWriter out = response.getWriter();
        out.print(JsonUtil.toJson(ru));
        out.close();
    }

    protected void getUserByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        int rows = Integer.parseInt(request.getParameter("rows"));
        int countRows = us.getCountRows();
        PageUtil pu = new PageUtil(page, rows, countRows);
        List<User> list = us.getCountUser(pu);
        pu.setList(list);
        PrintWriter out = response.getWriter();
        out.print(JsonUtil.toJson(pu));
        out.close();
    }

    protected void getUserByUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String page = request.getParameter("page");
        int rows = Integer.parseInt(request.getParameter("rows"));
        int countRows = us.getCountRowsByUsername(username);
        PageUtil pu = new PageUtil(page, rows, countRows);
        List<User> list = us.getUserByUsername(pu, username);
        pu.setList(list);
        PrintWriter out = response.getWriter();
        out.print(JsonUtil.toJson(pu));
        out.close();
    }

    protected void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        int status = Integer.parseInt(request.getParameter("status"));
        int role = Integer.parseInt(request.getParameter("role"));
        int age = Integer.parseInt(request.getParameter("age"));
        int sex = Integer.parseInt(request.getParameter("sex"));
        User user = new User(0, name, phone, age, sex, username, password, null, status, new Date(), role);
        String res = us.addUser(user);
        PrintWriter out = response.getWriter();
        out.print(res);
        out.close();
    }

    protected void delAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uids = request.getParameter("uids");
        String res = us.delAll(uids);
        PrintWriter out = response.getWriter();
        out.print(res);
        out.close();
    }

    protected void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int uid = Integer.parseInt(request.getParameter("uid"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        int status = Integer.parseInt(request.getParameter("status"));
        int role = Integer.parseInt(request.getParameter("role"));
        int age = Integer.parseInt(request.getParameter("age"));
        int sex = Integer.parseInt(request.getParameter("sex"));
        User user = new User(uid,name,phone,age,sex,username,password,null,status,null,role);
        String res = us.editUser(user);
        PrintWriter out = response.getWriter();
        out.print(res);
        out.close();
    }
}