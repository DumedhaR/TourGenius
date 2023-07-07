package com.tourgenius.accountservice.service;

import com.tourgenius.accountservice.dto.PropertyDto;
import com.tourgenius.accountservice.model.Property;

import java.util.List;

public interface PropertyService {
    String createProperty(PropertyDto propertyDto);

    String updateProperty(PropertyDto propertyDto, String id);

    boolean deleteProperty(String id);

    Property getPropertyByClient(String email);
}
