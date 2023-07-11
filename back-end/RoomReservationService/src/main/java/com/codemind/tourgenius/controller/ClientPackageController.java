package com.codemind.tourgenius.controller;

import com.codemind.tourgenius.dto.request.PackageRequest;
import com.codemind.tourgenius.dto.request.RoomSearchRequest;
import com.codemind.tourgenius.dto.response.RoomSearchResponse;
import com.codemind.tourgenius.repository.BookingRepository;
import com.codemind.tourgenius.service.ClientPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/package")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class ClientPackageController {

    @Autowired
    private ClientPackageService clientPackageService;


    @PostMapping("/create")
    public String createClientPackage(@RequestBody PackageRequest request) {
        return clientPackageService.create(request);
    }

    @PutMapping("/update/{id}")
    public String updateClientPackage(@PathVariable String id, @RequestBody PackageRequest request) {
        return clientPackageService.update(id, request);
    }

    @PostMapping("/search")
    public List<RoomSearchResponse> search(@RequestBody RoomSearchRequest roomSearchRequest) {
        return clientPackageService.search(roomSearchRequest);
    }

    @DeleteMapping("delete/{id}")
    public String deleteClientPackage(@PathVariable String id) {
        return clientPackageService.delete(id);
    }

}
