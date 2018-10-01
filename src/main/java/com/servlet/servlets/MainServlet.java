package com.servlet.servlets;

import com.servlet.domain.ShopStore;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/")
public class MainServlet extends HttpServlet {

    final static Logger logger = Logger.getLogger(MainServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("mypage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.info(req.getParameter("hero"));

        Map<Long, Object> items = ShopStore.getInstance().getAllItems();
        req.setAttribute("items", items);

        if("employee".equals(req.getParameter("hero"))){
            req.getRequestDispatcher("employee-start.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("customer-start.jsp").forward(req, resp);
        }
    }
}