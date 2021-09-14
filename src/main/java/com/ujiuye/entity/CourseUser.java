package com.ujiuye.entity;

public class CourseUser {
    private int id;
    private int cid;
    private int uid;
    private Course course;   //课程实体
    private User user;     //用户实体

    public CourseUser() {
    }

    public CourseUser(int id, int cid, int uid) {
        this.id = id;
        this.cid = cid;
        this.uid = uid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}