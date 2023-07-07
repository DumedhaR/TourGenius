package com.tourgenius.accountservice.service;

import com.tourgenius.accountservice.dto.PropertyDto;
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
    public String createProperty(@NotNull PropertyDto propertyDto) {
        Property property = Property.builder()
                .propertyName(propertyDto.getPropertyName())
                .description(propertyDto.getDescription())
                .coverImage(propertyDto.getCoverImage())
                .media(propertyDto.getMedia())
                .clientId(propertyDto.getClientId())
                .build();
        propertyRepository.save(property);
        return "Created";
    }

    @Override
    public String updateProperty(@NotNull PropertyDto propertyDto, String id) {
        Property currentProperty = propertyRepository.findById(id).orElseThrow();

        if(!propertyDto.getPropertyName().isEmpty()) {
            currentProperty.setPropertyName(propertyDto.getPropertyName());
        }
        if(propertyDto.getCoverImage() != null){
            currentProperty.setCoverImage(propertyDto.getCoverImage());
        }
        if(!propertyDto.getDescription().isEmpty()){
            currentProperty.setDescription(propertyDto.getDescription());
        }
        if(propertyDto.getMedia() != null){
            List<byte []> currentMedia = currentProperty.getMedia();
            currentMedia.addAll(propertyDto.getMedia());
            currentProperty.setMedia(currentMedia);
        }
        propertyRepository.save(currentProperty);
        return "Updated";
    }

    @Override
    public boolean deleteProperty(String id) {
        return propertyRepository.deleteByPropertyId(id);
    }

    @Override
    public Property getPropertyByClient(String email) {
        return propertyRepository.getPropertyByClientId(email);
    }
}
