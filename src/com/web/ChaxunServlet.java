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
 * @Date: 2020/11/25 14:49
 */
@WebServlet(name = "ChaxunServlet", urlPatterns = "/ChaxunServlet")
public class ChaxunServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        String n = request.getParameter("name");
        List<Student> list = studentDao.chaxun(n);
        request.setAttribute("list", list);
        request.getRequestDispatcher("/userList.jsp").forward(request, response);
    }
}
