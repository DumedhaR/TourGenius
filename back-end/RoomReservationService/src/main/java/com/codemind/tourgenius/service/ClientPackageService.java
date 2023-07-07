package com.codemind.tourgenius.service;

import com.codemind.tourgenius.dto.request.PackageRequest;
import com.codemind.tourgenius.dto.request.RoomSearchRequest;
import com.codemind.tourgenius.dto.response.RoomSearchResponse;
import com.codemind.tourgenius.model.Room;

import java.util.Date;
import java.util.List;

public interface ClientPackageService {

    String create(PackageRequest request);

    String update(String id, PackageRequest request);

    List<RoomSearchResponse> search(RoomSearchRequest roomSearchRequest);

    String delete(String id);

    List<String> getAvailableRoomsByClientPackage(String clientId, String packageId, Date checkIn, Date checkOut);

}
