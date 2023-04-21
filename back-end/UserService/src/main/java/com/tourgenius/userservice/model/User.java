package com.tourgenius.userservice.model;

import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "User")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id
    private String userId;
    @Field(name = "firstName")
    private String firstName;
    @Field(name = "lastName")
    private String lastName;
    @Field(name = "email")
    private String email;
    @Field(name = "dateOfBirth")
    private Date dateOfBirth;
    @Field(name = "country")
    private String country;
}
