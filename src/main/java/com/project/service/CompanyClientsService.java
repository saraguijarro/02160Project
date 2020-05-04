package com.project.service;

import com.project.dto.Client;
import com.project.dto.dao.Repository;
import com.project.repository.ClientRepository;

import java.util.ArrayList;

public class CompanyClientsService {

    private Repository<Client> clientRepository = new ClientRepository();


    public String[][] getClients() {
        ArrayList<Client> allClients = clientRepository.findAll();
        String[][] result = new String[allClients.size()][4];

        int i = 0;
        for(Client client: allClients) {
            String[] data = new String[4];
            data[0] = client.getName();
            data[1] = client.getAddress();
            data[2] = client.getReferencePerson();
            data[3] = client.getEmail();

            result[i] = data;
        }

        return result;
    }
}
