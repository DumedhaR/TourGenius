package com.tourgenius.clientservice.service;

import com.tourgenius.clientservice.dto.ClientDto;
import com.tourgenius.clientservice.model.Client;

public interface ClientService {

    Client createClient(ClientDto clientDto);
    Client updateClient(ClientDto clientDto);
    boolean deleteClient(String email);
    Client getClient(String email);

}
