package com.tourgenius.accountservice.service;

import com.tourgenius.accountservice.dto.PropertyDto;
import com.tourgenius.accountservice.model.Property;

import java.util.List;

public interface PropertyService {
    Property createProperty(PropertyDto propertyDto);

    Property updateProperty(PropertyDto propertyDto, String id);

    boolean deleteProperty(String id);

    List<Property> getPropertiesByClient(String email);
}
