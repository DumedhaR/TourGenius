package com.codemind.tourgenius.dto.response;

import com.codemind.tourgenius.model.ClientPackage;
import lombok.Data;

@Data
public class RoomSearchResponse {
    private ClientPackage clientPackage;
    private int roomsLeft;
}
