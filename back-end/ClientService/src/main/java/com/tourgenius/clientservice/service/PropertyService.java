package com.tourgenius.clientservice.service;

import com.tourgenius.clientservice.dto.PropertyDto;
import com.tourgenius.clientservice.model.Property;

import java.util.List;

public interface PropertyService {
    Property createProperty(PropertyDto propertyDto);

    Property updateProperty(PropertyDto propertyDto, String id);

    boolean deleteProperty(String id);

    List<Property> getPropertiesByClient(String email);
}
