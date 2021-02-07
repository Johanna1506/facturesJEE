package com.example.facturations.controllers;

import com.example.facturations.dto.ClientDTO;
import com.example.facturations.services.ClientService;

import java.io.*;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "NewClientServlet", value = "/newClient")
public class NewClientServlet extends  HttpServlet{

    @EJB
    private ClientService clientService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        this.getServletContext().getRequestDispatcher("/pages/formClients.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setNom(request.getParameter("nom"));
        clientDTO.setAdresse(request.getParameter("adresse"));
        clientService.create(clientDTO);

        this.getServletContext().getRequestDispatcher("/pages/reportClient.jsp").forward(request, response);
    }
}

