package com.tourgenius.accountservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    private String accountId;
    @Field(name = "password")
    private String password;
    @Field(name = "role")
    private String role;
}
