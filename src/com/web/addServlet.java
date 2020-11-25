package com.web;

import com.dao.StudentDaoImpl;
import com.daomian.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: Tanoty
 * @Date: 2020/11/23 14:08
 */
@WebServlet(name = "addServlet", urlPatterns = "/addServlet")
public class addServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = "请输入用户名称";
        String name = request.getParameter("userName");
        String password = request.getParameter("userRemi");
        String email = request.getParameter("userAddress");
        String love = request.getParameter("userLove");
        StudentDaoImpl studentDao = new StudentDaoImpl();
        boolean o = studentDao.storageUser(name, password, email, love);
        if (o) {
            List<Student> stu = studentDao.queryAllUsers();
            request.setAttribute("list", stu);
            request.getRequestDispatcher("/userList.jsp").forward(request, response);

        } else {
            request.setAttribute("uname", "该用户名已重复！");
            request.getRequestDispatcher("/userAdd.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
