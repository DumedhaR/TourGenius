package com.tourgenius.accountservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Client")
public class Client {
    @Id
    private String clientId;
    private String organizationName;
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String email;
    private byte[] profilePicture;
}
