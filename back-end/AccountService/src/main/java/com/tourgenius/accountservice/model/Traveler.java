package com.tourgenius.accountservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Traveler")
public class Traveler {
    @Id
    private String travelerId;
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
    @Field(name = "profilePicture")
    private byte[] profilePicture;
}
