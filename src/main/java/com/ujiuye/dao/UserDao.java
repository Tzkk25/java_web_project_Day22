package com.ujiuye.dao;

import com.ujiuye.entity.User;
import com.ujiuye.util.PageUtil;

import java.util.List;

public interface UserDao {
    //判断登录
    public User login(String username,String password);
    //统计总的信息条数
    public int getCountRows();
    //通过手动选择页数显示信息
    public List<User> getUserByPage(PageUtil pu);
    //通过输入名字查询时先统计以下带有那个字母的用户名
    public int getCountRowsByUsername(String username);
    //通过输入昵称进行查询
    public List<User> getUserByUsername(PageUtil pu, String username);
    //新增用户
    public int addUser(User user);
    //批量删除
    public int delAll(String uids);
    //修改方法
    public int editUser(User user);
    //通过id查询到对应的用户信息
    public User getUserByUid(int uid);
    //小U课堂中的注册功能中的检查手机号是否存在
    User checkPhone(String phone);
    //小U课堂界面的注册功能
    int regist(User user);
    //小U课堂登录功能
    User userLogin(String phone,String password);
}
