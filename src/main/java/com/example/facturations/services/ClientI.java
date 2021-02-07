package com.example.facturations.services;

import com.example.facturations.dto.ClientDTO;
import com.example.facturations.entite.Clients;

import java.util.List;

public interface ClientI {
    List<Clients> findAllClients();
    void create(ClientDTO clientDTO);
}
