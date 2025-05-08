package com.movie.ticket;


import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/book")
public class Movie extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        String name = servletRequest.getParameter("name");
        String contact = servletRequest.getParameter("contact");
        long phone = 0;
        if (contact != null && !contact.isEmpty()) {
            phone = Long.parseLong(contact);
        }

        String noticket = servletRequest.getParameter("noticket");
        int ticket = 0;
        if (noticket != null && !noticket.isEmpty()) {
            ticket = Integer.parseInt(noticket);
        }

        String price = servletRequest.getParameter("price");
        int rate = 0;
        if (price != null && !price.isEmpty()) {
            rate = Integer.parseInt(price);
        }

        int total = rate * ticket;

        servletResponse.setContentType("text/plain");
        PrintWriter writer = servletResponse.getWriter();

        writer.println("Ticket Booking Confirmation");
        writer.println("Name: " + name);
        writer.println("Phone: " + phone);
        writer.println("Number of Tickets: " + ticket);
        writer.println("Price per Ticket: " + rate);
        writer.println("Total Price: " + total);
    }
}

