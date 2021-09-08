package com.ujiuye.util;

public class PageUtil {
    private int page;//当前页数
    private int rows;//每页显示条数
    private int index;//偏移量,就是用在查询中的查询第几页的第一个数据在总数据中在第几个
    private int countRows;//总条数
    private int countPage;//总的分页数
    private int prevPage;//上一页
    private int nextPage;//下一页
    private Object list;//分页得到的数据,通过查询语句返回的list集合

    public PageUtil(String page,int rows,int countRows){
        this.rows = rows;
        this.countRows = countRows;
        init_page(page);
        init_index();
        init_countPage();
        init_prevPage();
        init_nextPage();
    }

    //页码的初始化
    private void init_page(String page){
        if(page == null || "".equals(page)){
            this.page = 1;
        }else{
            this.page = Integer.parseInt(page);
        }
    }

    //初始化偏移量
    private void init_index(){
        this.index = (this.page - 1) * this.rows;
    }

    //初始化总页数
    private void init_countPage(){
        int mod = this.countRows % this.rows;
        if(mod == 0){
            this.countPage = this.countRows / this.rows;
        }else{
            this.countPage = this.countRows / this.rows + 1;
        }
    }

    //初始化当前页的上一页页码
    private void init_prevPage(){
        if(this.page == 1){
            this.prevPage = 1;
        }else{
            this.prevPage = this.page - 1;
        }
    }

    //初始化当前页的下一页页码
    private void init_nextPage(){
        if(this.page == this.countPage){
            this.nextPage = this.countPage;
        }else{
            this.nextPage = this.page + 1;
        }
    }

    public int getPage() {
        return page;
    }

    public int getRows() {
        return rows;
    }

    public int getIndex() {
        return index;
    }

    public int getCountRows() {
        return countRows;
    }

    public int getCountPage() {
        return countPage;
    }

    public int getPrevPage() {
        return prevPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public Object getList() {
        return list;
    }

    public void setList(Object list) {
        this.list = list;
    }
}
