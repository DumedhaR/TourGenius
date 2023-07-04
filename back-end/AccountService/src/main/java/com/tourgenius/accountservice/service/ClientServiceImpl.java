package com.tourgenius.accountservice.service;

import com.tourgenius.accountservice.dto.ClientDto;
import com.tourgenius.accountservice.model.Account;
import com.tourgenius.accountservice.model.Client;
import com.tourgenius.accountservice.repository.AccountRepository;
import com.tourgenius.accountservice.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService{

   private final ClientRepository clientRepository;
   private final AccountRepository accountRepository;
   private final AccountService accountService;


   @Override
   public ResponseEntity<String> createClient(@NotNull ClientDto clientDto) {
      Account account = accountRepository.findAccountByEmail(clientDto.getEmail()).orElseThrow();
      Client client = new Client();
      client.setOrganizationName(clientDto.getOrganizationName());
      client.setFirstName(clientDto.getFirstName());
      client.setLastName(clientDto.getLastName());
      client.setContactNumber(clientDto.getContactNumber());
      client.setEmail(clientDto.getEmail());
      client.setProfilePicture(clientDto.getProfilePicture());
      clientRepository.save(client);
      return ResponseEntity.ok().headers(accountService.setTokenCookies(account)).body("created");
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
      return clientRepository.findClientByEmail(email).orElseThrow();
   }
}
