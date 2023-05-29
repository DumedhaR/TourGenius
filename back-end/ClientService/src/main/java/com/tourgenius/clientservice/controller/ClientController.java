package com.tourgenius.clientservice.controller;

import com.tourgenius.clientservice.dto.ClientDto;
import com.tourgenius.clientservice.dto.PropertyDto;
import com.tourgenius.clientservice.model.Client;
import com.tourgenius.clientservice.model.Property;
import com.tourgenius.clientservice.service.ClientService;
import com.tourgenius.clientservice.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final PropertyService propertyService;

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
    @PostMapping("/property/create")
    public Property createProperty(@RequestBody PropertyDto propertyDto){
        return propertyService.createProperty(propertyDto);
    }
    @PutMapping("/property/update/{id}")
    public Property updateProperty(@RequestBody PropertyDto propertyDto, String id){
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
