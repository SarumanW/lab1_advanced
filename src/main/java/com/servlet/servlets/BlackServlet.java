package com.servlet.servlets;

import com.servlet.domain.Item;
import com.servlet.domain.ShopStore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/black")
public class BlackServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        req.setAttribute("help", "Done! You can add items again!");
        req.getRequestDispatcher("items.jsp").forward(req, resp);
    }
}
