package com.example.facturations.controllers;

import com.example.facturations.entite.Clients;
import com.example.facturations.services.ClientI;

import java.io.*;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "clientsServlet", value = "/clients")
public class ClientsServlet extends HttpServlet {
    @EJB
    private ClientI clientService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Clients> clients = this.clientService.findAllClients();

        request.setAttribute("clients", clients);

        this.getServletContext().getRequestDispatcher("/pages/clients.jsp").forward(request, response);
    }
}