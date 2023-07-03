package com.tourgenius.accountservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MediaUtil {
    private String name;
    private String type;
    private byte[] file;
}
