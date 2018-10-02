package com.servlet.servlets;

import com.servlet.domain.Customer;
import com.servlet.domain.Item;
import com.servlet.domain.Purchase;
import com.servlet.domain.ShopStore;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(MainServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String[] checkedItems = req.getParameterValues("itemCheck");
        String[] productsCount = req.getParameterValues("productsCount");
        String customerName = req.getParameter("customerName");

        Object[] checkedCounts = Arrays.stream(productsCount).filter(x -> x!=null && !x.isEmpty()).toArray();

        logger.info("CheckedCounts: " + checkedCounts.length + " - " + checkedCounts[0]);

        Customer customer = ShopStore.getInstance().getCustomer(customerName);

        if(customer == null){
            customer = new Customer(customerName);
            ShopStore.getInstance().putCustomer(customer);
        }

        Purchase purchase = new Purchase(customer, ShopStore.getInstance().getArrayOfItemsByIds(checkedItems,
                Arrays.copyOf(checkedCounts, checkedCounts.length, String[].class)));

        ShopStore.getInstance().putPurchase(purchase);

        logger.info("Customer made a purchase: " + purchase);
        logger.info("Purchases count in base: " + ShopStore.getInstance().getAllPurchases().size());

        req.setAttribute("thanks", "Thank you for choosing our shop! You can buy more products again!");
        req.getRequestDispatcher("customer-start.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("customer-start.jsp").forward(req, resp);
    }
}
