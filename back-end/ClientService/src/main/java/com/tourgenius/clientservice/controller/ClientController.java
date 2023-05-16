package com.tourgenius.clientservice.controller;

import com.tourgenius.clientservice.dto.ClientDto;
import com.tourgenius.clientservice.model.Client;
import com.tourgenius.clientservice.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/create")
    public Client createClient(@RequestBody ClientDto clientDto){
        return clientService.createClient(clientDto);
    }
}
