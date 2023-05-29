package com.tourgenius.clientservice.service;

import com.tourgenius.clientservice.dto.AccountDto;
import com.tourgenius.clientservice.dto.ClientDto;
import com.tourgenius.clientservice.model.Client;
import com.tourgenius.clientservice.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService{

   private final ClientRepository clientRepository;
   private final RestTemplate restTemplate;


   @Override
   public Client createClient(@NotNull ClientDto clientDto) {
      AccountDto accountDto = new AccountDto();
      accountDto.setEmail(clientDto.getEmail());
      accountDto.setPassword(clientDto.getPassword());
      accountDto.setRole("Client");
      boolean response =
              Objects.equals(Boolean.TRUE, restTemplate.postForObject("http://localhost:9001/accounts/create", accountDto, Boolean.class));
      if(!response){
         throw new HttpClientErrorException(HttpStatusCode.valueOf(409),"Given email is already used!");
      }
      Client client = new Client();
      client.setOrganizationName(clientDto.getOrganizationName());
      client.setFirstName(clientDto.getFirstName());
      client.setLastName(clientDto.getLastName());
      client.setContactNumber(clientDto.getContactNumber());
      client.setEmail(clientDto.getEmail());
      client.setProfilePicture(clientDto.getProfilePicture());
      return clientRepository.save(client) ;
   }

   @Override
   public Client updateClient(@NotNull ClientDto clientDto) {
      Client current = getClient(clientDto.getEmail());
      if (clientDto.getFirstName() != null) {
         current.setFirstName(clientDto.getFirstName());
      }
      if (clientDto.getLastName() != null) {
         current.setLastName(clientDto.getLastName());
      }
      if (clientDto.getOrganizationName() != null){
         current.setOrganizationName(clientDto.getOrganizationName());
      }
      if (clientDto.getContactNumber() != null){
         current.setContactNumber(clientDto.getContactNumber());
      }
      if (clientDto.getProfilePicture() != null) {
         current.setProfilePicture(clientDto.getProfilePicture());
      }
      return clientRepository.save(current);
   }

   @Override
   public boolean deleteClient(String email) {
      return clientRepository.deleteClientByEmail(email);
   }

   @Override
   public Client getClient(String email) {
      return clientRepository.findClientByEmail(email);
   }
}
