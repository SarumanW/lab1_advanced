package com.servlet.servlets;

import com.servlet.domain.Customer;
import com.servlet.domain.ShopStore;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/purchase")
public class PurchaseServlet extends HttpServlet {

    final static Logger logger = Logger.getLogger(MainServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String customerId = req.getParameter("addToBlackList");
        logger.info("Customer id: " + customerId);
        Customer customer = ShopStore.getInstance().getCustomer(customerId);
        logger.info("Customer: " + customer);
        ShopStore.getInstance().putCustomerToBlackList(customer);

        req.setAttribute("help", "Done! You can add one more customer again!");
        req.getRequestDispatcher("items.jsp").forward(req, resp);
    }
}
