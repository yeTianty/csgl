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
 * @Date: 2020/11/25 13:54
 */
@WebServlet(name = "DeleteUserServlet", urlPatterns = "/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        String n = request.getParameter("name");
        System.out.println(n);
        boolean d = studentDao.deleteUser(n);
        List<Student> list = studentDao.queryAllUsers();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/userList.jsp").forward(request, response);
    }
}
