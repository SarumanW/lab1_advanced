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

        String[] checkboxes = req.getParameterValues("itemCheck");
        logger.info("Checked checkboxes array size: " + checkboxes.length);
        logger.info("First checked item name: " + checkboxes[0]);

        req.getRequestDispatcher("employee-start.jsp").forward(req, resp);

    }
}
