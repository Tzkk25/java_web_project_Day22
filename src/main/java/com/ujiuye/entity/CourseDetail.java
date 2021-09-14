package com.ujiuye.entity;

public class CourseDetail {
    private int  id;
    private String  name;
    private String  type;
    private String  url;
    private int  cid;
    private String start_data;

    public CourseDetail() {
    }

    public CourseDetail(int id, String name, String type, String url, int cid, String start_data) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.url = url;
        this.cid = cid;
        this.start_data = start_data;
    }

    public String getStart_data() {
        return start_data;
    }

    public void setStart_data(String start_data) {
        this.start_data = start_data;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}