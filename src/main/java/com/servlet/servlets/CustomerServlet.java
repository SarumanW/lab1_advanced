package com.servlet.servlets;

import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/app/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(MyServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("name", "Galina");

        logger.info("Get method of customerServlet was invoked");

        req.getRequestDispatcher("customer-start.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("name", "Galina");

        logger.info("Get method of customerServlet was invoked");

        req.getRequestDispatcher("customer-start.jsp").forward(req, resp);
    }
}
