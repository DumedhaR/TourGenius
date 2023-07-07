package com.tourgenius.accountservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Client")
public class Client {
    @Id
    private String clientId;
    @NonNull
    private String organizationName;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String contactNumber;
    @NonNull
    private String email;
    @Nullable
    private byte[] profilePicture;
}
