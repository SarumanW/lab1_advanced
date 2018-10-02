package com.servlet.servlets;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(MainServlet.class);

    protected void doPost (HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if("Items list".equals(req.getParameter("action"))){
            req.getRequestDispatcher("items.jsp").forward(req, resp);
        } else if("Purchases list".equals(req.getParameter("action"))){
            req.getRequestDispatcher("purchases.jsp").forward(req, resp);
        }
    }

    protected void doGet (HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("employee-start.jsp").forward(req, resp);
    }
}
