package com.tourgenius.clientservice.controller;

import com.tourgenius.clientservice.dto.ClientDto;
import com.tourgenius.clientservice.model.Client;
import com.tourgenius.clientservice.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/create")
    public Client createClient(@RequestBody ClientDto clientDto){
        return clientService.createClient(clientDto);
    }
    @PutMapping("/update")
    public Client updateClient(@RequestBody ClientDto clientDto) {
        return clientService.updateClient(clientDto);
    }
    @DeleteMapping("/delete/{email}")
    public boolean deleteClient(@PathVariable String email){
        return clientService.deleteClient(email);
    }
    @GetMapping("/{email}")
    public Client getClient(@PathVariable String email){
        return clientService.getClient(email);
    }


}
