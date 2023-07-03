package com.tourgenius.accountservice.service;

import com.tourgenius.accountservice.dto.ClientDto;
import com.tourgenius.accountservice.model.Client;

public interface ClientService {

    Client createClient(ClientDto clientDto);
    Client updateClient(ClientDto clientDto);
    boolean deleteClient(String email);
    Client getClient(String email);

}
