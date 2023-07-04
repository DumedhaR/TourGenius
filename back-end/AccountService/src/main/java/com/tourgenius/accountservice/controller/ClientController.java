package com.tourgenius.accountservice.controller;

import com.tourgenius.accountservice.dto.ClientDto;
import com.tourgenius.accountservice.dto.PropertyDto;
import com.tourgenius.accountservice.model.Client;
import com.tourgenius.accountservice.model.Property;
import com.tourgenius.accountservice.service.ClientService;
import com.tourgenius.accountservice.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final PropertyService propertyService;

    @PostMapping("/create")
    public ResponseEntity<String> createClient(@RequestBody ClientDto clientDto){
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
    @GetMapping("/get/{email}")
    public Client getClient(@PathVariable String email){
        return clientService.getClient(email);
    }
    @PostMapping("/property/create")
    public Property createProperty(@RequestBody PropertyDto propertyDto){
        return propertyService.createProperty(propertyDto);
    }
    @PutMapping("/property/update/{id}")
    public Property updateProperty(@RequestBody PropertyDto propertyDto, @PathVariable String id){
        return propertyService.updateProperty(propertyDto, id);
    }
    @DeleteMapping("/property/delete/{id}")
    public boolean deleteProperty(@PathVariable String id){

        return propertyService.deleteProperty(id);
    }
    @GetMapping("property/all/{email}")
    public List<Property> getClientAllProperties(@PathVariable String email){
        return propertyService.getPropertiesByClient(email);
    }
}
