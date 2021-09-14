package com.ujiuye.service.impl;

import com.ujiuye.dao.UserDao;
import com.ujiuye.dao.impl.UserDaoImpl;
import com.ujiuye.entity.User;
import com.ujiuye.service.UserService;
import com.ujiuye.util.JsonUtil;
import com.ujiuye.util.PageUtil;
import com.ujiuye.util.ResultUtil;

import javax.servlet.http.HttpSession;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao ud = new UserDaoImpl();
    @Override
    public String login(String username, String password, String code, HttpSession session) {
        //判断验证码是否正确,验证码正确的前提下才去验证账户密码
        ResultUtil ru = null;
        String verCode = (String) session.getAttribute("verCode");
        //验证码忽略大小写验证
        if (code.equalsIgnoreCase(verCode)){
            //验证码正确
            User user = ud.login(username,password);
            if (user != null){
                //账号密码正确的前提下,判断账户是否禁用,
                if (user.getStatus()==1){
                    //账号正常使用
                    //账号正常使用的前提下,判断是否是管理员账号
                    if(user.getRole()==1){
                        //是管理员账号,可以正常登录
                        session.setAttribute("user",user);
                        ru = new ResultUtil(1,"恭喜,登录成功",null);
                    }else {
                        //非管理员账号
                        ru = new ResultUtil(2,"该账号非管理员账号",null);
                    }
                }else {
                    //账号被禁用
                    ru = new ResultUtil(3,"账号被禁用,请联系管理员",null);
                }
            }else {
                //账号密码不正确
                ru = new ResultUtil(4,"账号或者密码不正确",null);
            }
        }else {
            //验证码不正确
            ru = new ResultUtil(5,"亲,你好,你于刚刚输入的验证码不正确",null);
        }
        return JsonUtil.toJson(ru);
    }

    @Override
    public int getCountRows() {
        return ud.getCountRows();
    }

    @Override
    public List<User> getCountUser(PageUtil pu) {
        return ud.getUserByPage(pu);
    }

    @Override
    public int getCountRowsByUsername(String username) {
        return ud.getCountRowsByUsername(username);
    }

    @Override
    public List<User> getUserByUsername(PageUtil pu, String username) {
        return ud.getUserByUsername(pu,username);
    }

    @Override
    public String addUser(User user) {
        ResultUtil ru = null;
        int rows = ud.addUser(user);
        if (rows == 0){
            ru = new ResultUtil(0,"添加失败",null);
        }else {
            ru = new ResultUtil(1,"添加成功",null);
        }
        return JsonUtil.toJson(ru);
    }

    @Override
    public String delAll(String uids) {
        ResultUtil ru = null;
        int rows = ud.delAll(uids);
        if (rows == 0){
            ru = new ResultUtil(0,"删除失败",null);
        }else {
            ru = new ResultUtil(1,"删除成功",null);
        }
        return JsonUtil.toJson(ru);
    }

    @Override
    public String editUser(User user) {
        ResultUtil ru = null;
        int rows = ud.editUser(user);
        if (rows == 0){
            ru = new ResultUtil(0,"修改失败",null);
        }else{
            ru = new ResultUtil(1,"修改成功",null);
        }
        return JsonUtil.toJson(ru);
    }

    @Override
    public String checkPhone(String phone) {
        ResultUtil ru = null;
        User user = ud.checkPhone(phone);
        if (user == null){
            //数据库中没有此号码被注册,可以使用
            ru = new ResultUtil(0,"能使用",null);
        }else{
            //数据库中能查到此号码被注册,不可以使用
            ru = new ResultUtil(1,"手机号已经被注册",null);
        }
        return JsonUtil.toJson(ru);
    }

    @Override
    public String regist(User user) {
        ResultUtil ru = null;
        int rows = ud.regist(user);
        if(rows == 0){
            ru = new ResultUtil(0,"注册失败,请稍后再试",null);
        }else {
            ru = new ResultUtil(1,"注册成功",null);
        }
        return JsonUtil.toJson(ru);
    }

    @Override
    public String userLogin(String phone, String password) {
        ResultUtil ru = null;
        User user= ud.userLogin(phone,password);
        if(user == null){
            ru = new ResultUtil(0,"账号密码有误,请重新输入",null);
        }else{
            if (user.getStatus()==1){
                ru = new ResultUtil(1,"登录成功",user);
            }else{
                ru = new ResultUtil(2,"账号被禁用,无法登录",null);
            }
        }
        return JsonUtil.toJson(ru);
    }
}