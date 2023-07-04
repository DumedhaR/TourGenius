package com.tourgenius.accountservice.service;

import com.tourgenius.accountservice.dto.PropertyDto;
import com.tourgenius.accountservice.dto.MediaUtil;
import com.tourgenius.accountservice.model.Property;
import com.tourgenius.accountservice.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService{

    private final PropertyRepository propertyRepository;

    @Override
    public Property createProperty(@NotNull PropertyDto propertyDto) {
        Property property = Property.builder()
                .propertyName(propertyDto.getPropertyName())
                .type(propertyDto.getType())
                .description(propertyDto.getDescription())
                .media(propertyDto.getMedia())
                .clientId(propertyDto.getClientId())
                .build();
        return propertyRepository.save(property);
    }

    @Override
    public Property updateProperty(@NotNull PropertyDto propertyDto, String id) {
        Property currentProperty = propertyRepository.findById(id).orElseThrow();

        if(!propertyDto.getPropertyName().isEmpty()) {
            currentProperty.setPropertyName(propertyDto.getPropertyName());
        }
        if(!propertyDto.getType().isEmpty()){
            currentProperty.setType(propertyDto.getType());
        }
        if(!propertyDto.getDescription().isEmpty()){
            currentProperty.setDescription(propertyDto.getDescription());
        }
        if(!propertyDto.getMedia().isEmpty()){
            List<MediaUtil> currentMedia = currentProperty.getMedia();
            currentMedia.addAll(propertyDto.getMedia());
            currentProperty.setMedia(currentMedia);
        }
        return propertyRepository.save(currentProperty);
    }

    @Override
    public boolean deleteProperty(String id) {
        return propertyRepository.deleteByPropertyId(id);
    }

    @Override
    public List<Property> getPropertiesByClient(String email) {
        return propertyRepository.getPropertiesByClientId(email);
    }
}
