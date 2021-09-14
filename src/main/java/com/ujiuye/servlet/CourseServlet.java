package com.ujiuye.servlet;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.ujiuye.entity.Course;
import com.ujiuye.service.CourseService;
import com.ujiuye.service.impl.CourseServiceImpl;
import com.ujiuye.util.JsonUtil;
import com.ujiuye.util.PageUtil;
import com.ujiuye.util.ResultUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.omg.PortableInterceptor.INACTIVE;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@MultipartConfig
@WebServlet("/courseServlet")
public class CourseServlet extends BaseServlet {
    CourseService cs = new CourseServiceImpl();

    protected void getCourseByCourseName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseName = request.getParameter("courseName");
        String page = request.getParameter("page");
        int rows = Integer.parseInt(request.getParameter("rows"));
        int countRows = cs.getCountRowsByCourseName(courseName);
//        System.out.println(countRows);
        PageUtil pu = new PageUtil(page,rows,countRows);
        List<Course> list = cs.getCourseByCourseName(courseName,pu);
        pu.setList(list);
        PrintWriter out = response.getWriter();
        out.print(JsonUtil.toJson(pu));
        out.close();
    }
    protected void upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取上传的文件对象
        Part part = request.getPart("file");
        //获取上传的文件的名字
        String fileName = UUID.randomUUID()+part.getSubmittedFileName();
        //上路的路径
        String path = "F:/education_pic/course";
        File file = new File(path);
        //上传时判断文件是否存在
        if (!file.exists()){
            file.mkdirs();
        }
        //在上传的路劲创建指定的文件
        part.write(path+"/"+fileName);
        //将文件在服务器上的地址返回给前端
        String url = "http://localhost:8080/education_pic/course/"+fileName;
        ResultUtil ru = null;
        if (fileName.contains("jpg")||fileName.contains("jpeg")||fileName.contains("png")||fileName.contains("gif")){
            ru = new ResultUtil(1,"图片上传成功",url);
        }else {
            ru = new ResultUtil(2,"视频上传成功",url);
        }
        PrintWriter out = response.getWriter();
        out.print(JsonUtil.toJson(ru));
        out.close();
    }
    //删除上传的文件
    protected void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取要删除的文件名
        String fileName = request.getParameter("fileName");
        fileName = fileName.substring(fileName.lastIndexOf("/")+1);
        String path = "F:/education_pic/course/"+fileName;
        File file = new File(path);
        file.delete();
        ResultUtil ru = null;
        if (fileName.contains("jpg") || fileName.contains("jpeg") || fileName.contains("png") || fileName.contains("gif")){
            ru = new ResultUtil(1,"图片删除成功",null);
        }else{
            ru = new ResultUtil(2,"视频删除成功",null);
        }
        PrintWriter out = response.getWriter();
        out.print(JsonUtil.toJson(ru));
        out.close();
    }
    //新增课程信息
    protected void addCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        //可以使用getParameterMap()一次获取所有传递过来的键值对
        //不过传递的键值对必须和实例类信息一致
        //key代表的就是数据的名字,value就是数据的值
        //下面之所以用数组是因为不使用数组没有办法获取复选框的值
        Map<String ,String[]> map = request.getParameterMap();
        //将map集合解析成对应的实体对象
        Course c= new Course();
        BeanUtils.populate(c,map);
        c.setCreateTime(new Date());
        c.setCourseImage(c.getCourseImage().substring(c.getCourseImage().lastIndexOf("/")+1));
        c.setCourseVideo(c.getCourseVideo().substring(c.getCourseVideo().lastIndexOf("/")+1));
        String res = cs.addCourse(c);
        PrintWriter out = response.getWriter();
        out.print(res);
        out.close();
    }
    //删除选中的信息
    protected void delAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        String cids = request.getParameter("cids");
        String res = cs.delAll(cids);
        PrintWriter out = response.getWriter();
        out.print(res);
        out.close();
    }
    //修改信息
    protected void editCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        //一次性获取所有提交的数据
        //key就是数据的名字,value就是数据的值
        Map<String,String[]> map = request.getParameterMap();
        //将map集合中的数据解析成对应的实体对象
        Course c = new Course();
        BeanUtils.populate(c,map);
        c.setCourseImage(c.getCourseImage().substring(c.getCourseImage().lastIndexOf("/")+1));
        c.setCourseVideo(c.getCourseVideo().substring(c.getCourseVideo().lastIndexOf("/")+1));
        String res = cs.editCourse(c);
        PrintWriter out = response.getWriter();
        out.print(res);
        out.close();
    }
    protected void getAllCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        List<Course> list = cs.getAllCourse();
        PrintWriter out = response.getWriter();
        out.print(JsonUtil.toJson(list));
        out.close();
    }
    protected void getCourseByType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        int courseType = Integer.parseInt(request.getParameter("courseType"));
        int count = Integer.parseInt(request.getParameter("count"));
        List<Course> list = cs.getCourseByType(courseType,count);
        PrintWriter out = response.getWriter();
        out.print(JsonUtil.toJson(list));
        out.close();
    }
    protected void getCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        String page = request.getParameter("page");
        int rows = Integer.parseInt(request.getParameter("rows"));
        int countRows = cs.getCountRows();
        PageUtil pu = new PageUtil(page,rows,countRows);
        List<Course> list = cs.getCourse(pu);
        pu.setList(list);
        PrintWriter out = response.getWriter();
        out.print(JsonUtil.toJson(pu));
        out.close();
    }
}