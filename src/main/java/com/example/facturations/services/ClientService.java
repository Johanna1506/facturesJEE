package com.example.facturations.services;
import com.example.facturations.dto.ClientDTO;
import com.example.facturations.entite.Clients;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ClientService implements ClientI {

    @PersistenceContext(unitName = "factures")
    EntityManager entityManager;

    @Resource
    UserTransaction userTransaction;

    @Override
    public List<Clients> findAllClients() {
        List<Clients> clients = entityManager.createQuery("Select c from Clients c").getResultList();
        return clients;
    }

    @Override
    public void create(ClientDTO clientDto) {
        Clients client = new Clients();
        client.setName(clientDto.getName());
        client.setAdresse(clientDto.getAdresse());

        try{
            userTransaction.begin();
            entityManager.persist(client);
            userTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}