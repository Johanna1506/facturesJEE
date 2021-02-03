package com.example.facturations.controllers;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "articlesServlet", value = "/articles")
public class ArticlesServlet extends HttpServlet{
    private String message;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        this.getServletContext().getRequestDispatcher("/WEB-INF/clients.jsp").forward(request, response);
    }

    public void destroy() {
    }
}
