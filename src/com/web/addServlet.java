package com.web;

import com.dao.StudentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Tanoty
 * @Date: 2020/11/23 14:08
 */
@WebServlet(name = "addServlet", urlPatterns = "/addServlet")
public class addServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = "请输入用户名称";
        String name = request.getParameter("userName");
        String password = request.getParameter("userRemi");
        String email = request.getParameter("userAddress");
        String love = request.getParameter("userLove");
        StudentDaoImpl studentDao = new StudentDaoImpl();
        int i = studentDao.storageUser(name, password, email, love);
        if (i == 1) {
            str = "该用户名已重复";
        } else if (i == 2) {
            request.getRequestDispatcher("/userAdd.jsp").forward(request, response);
        } else if (i == 0) {
            request.getRequestDispatcher("/userAdd.jsp").forward(request, response);
        }
        request.setAttribute("str", str);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
