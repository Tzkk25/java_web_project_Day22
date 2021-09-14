package com.ujiuye.service;

import com.ujiuye.entity.User;
import com.ujiuye.util.PageUtil;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {
    public String login(String username, String password, String code, HttpSession session);
    //获取用户个数
    public int getCountRows();
    //根据页码获取用户信息
    public List<User> getCountUser(PageUtil pu);
    //通过用户名查询
    public int getCountRowsByUsername(String username);
    //根据用户名返回模糊查询
    public List<User> getUserByUsername(PageUtil pu,String username);
    //新增用户
    public String addUser(User user);
    //批量删除
    public String delAll(String uids);
    //修改数据
    public String editUser(User user);
    //小U课堂中注册功能模块的检测手机号是否被注册
    public String checkPhone(String phone);
    //小U课堂中的注册功能
    public String regist(User user);
    //小U课堂中的登录功能
    public String userLogin(String phone, String password);
}
