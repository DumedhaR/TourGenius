package com.tourgenius.adminservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Admin")
@Data
@NoArgsConstructor
public class Admin {
    @Id
    private String email;
    private String password;
    private String name;
}
