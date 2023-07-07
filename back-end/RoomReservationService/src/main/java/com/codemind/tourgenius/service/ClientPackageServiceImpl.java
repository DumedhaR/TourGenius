package com.codemind.tourgenius.service;

import com.codemind.tourgenius.dto.request.PackageRequest;
import com.codemind.tourgenius.dto.request.RoomSearchRequest;
import com.codemind.tourgenius.dto.response.RoomSearchResponse;
import com.codemind.tourgenius.model.Booking;
import com.codemind.tourgenius.model.ClientPackage;
import com.codemind.tourgenius.model.Room;
import com.codemind.tourgenius.repository.BookingRepository;
import com.codemind.tourgenius.repository.ClientPackageRepository;
import com.codemind.tourgenius.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ClientPackageServiceImpl implements ClientPackageService {
    @Autowired
    private ClientPackageRepository clientPackageRepository;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private RoomRepository roomRepository;

    @Transactional
    @Override
    public String create(PackageRequest request) {
        ClientPackage clientPackage = new ClientPackage();
        clientPackage.setClientId(request.getClientId());
        clientPackage.setPackageName(request.getPackageName());
        clientPackage.setMaxGuest(request.getMaxGuest());
        clientPackage.setSize(request.getSize());
        clientPackage.setPrice(request.getPrice());
        clientPackage.setRoomDesc(request.getRoomDesc());
        clientPackage.setTotalRooms(request.getTotalRooms());
        clientPackage.setCoverImage(request.getCoverImage());
        clientPackage.setFeatures(request.getFeatures());
        ClientPackage newPackage = clientPackageRepository.save(clientPackage) ;
        for(int x=0 ; x < newPackage.getTotalRooms() ; x++){
            Room room = new Room();
            room.setPackageId(newPackage.getId());
            room.setClientId(newPackage.getClientId());
            roomRepository.save(room);
        }
        return "created";
    }

    @Transactional
    @Override
    public String update(String id, PackageRequest request) {
        ClientPackage current = clientPackageRepository.findById(id).orElseThrow();
        if(request.getClientId() != null){
            current.setClientId(request.getClientId());
        }
        if(request.getPackageName() != null){
            current.setPackageName(request.getPackageName());
        }
        if(request.getMaxGuest() > 0){
            current.setMaxGuest(request.getMaxGuest());
        }
        if(request.getPrice() != null){
            current.setPrice(request.getPrice());
        }
        if(request.getRoomDesc() != null){
            current.setRoomDesc(request.getRoomDesc());
        }
        if(request.getTotalRooms() > 0){
            if(request.getTotalRooms()>current.getTotalRooms()){
                int change = request.getTotalRooms() - current.getTotalRooms();
                for(int x=0 ; x < change ; x++){
                    Room room = new Room();
                    room.setPackageId(current.getId());
                    room.setClientId(current.getClientId());
                    roomRepository.save(room);
                }
            }else{
                int change = current.getTotalRooms() - request.getTotalRooms();
                List<String> currentRooms = getRoomIdsByPackageId(current.getId());
                for (int x=0 ; x < change ; x++){
                    roomRepository.deleteById(currentRooms.get(x));
                }
            }
            current.setTotalRooms(request.getTotalRooms());
        }
        if(request.getCoverImage() != null){
            current.setCoverImage(request.getCoverImage());
        }
        if(request.getFeatures() != null){
            current.setFeatures(request.getFeatures());
        }
        clientPackageRepository.save(current);
        return "updated";
    }

    @Override
    public List<RoomSearchResponse> search(RoomSearchRequest roomSearchRequest) {
        List<RoomSearchResponse> searchResult = new ArrayList<>();
        Map<String, Set<String>> bookedRoomsByClientPackages =
                getBookedRoomsByClientPackages(roomSearchRequest.getClientId(), roomSearchRequest.getCheckInDate(), roomSearchRequest.getCheckOutDate());
        List<ClientPackage> clientPackages = clientPackageRepository.findAll();
        for (ClientPackage clientPackage : clientPackages){
            int roomsLeft = clientPackage.getTotalRooms() - bookedRoomsByClientPackages.get(clientPackage.getId()).size();
            RoomSearchResponse roomSearchResponse = new RoomSearchResponse();
            roomSearchResponse.setClientPackage(clientPackage);
            roomSearchResponse.setRoomsLeft(Math.max(roomsLeft, 0));
            searchResult.add(roomSearchResponse);
        }
        return searchResult;
    }

    private Map<String, Set<String>> getBookedRoomsByClientPackages(String clientId, Date checkIn, Date checkOut) {
        List<Booking> clashingBookings = bookingRepository.findClashingBookings(clientId, checkIn, checkOut);
        List<ClientPackage> clientPackages = clientPackageRepository.findAll();
        Map<String, Set<String>> bookedRooms = new HashMap<>();
        for (ClientPackage clientPackage : clientPackages){
            Set<String> roomIds = new HashSet<>();
            if(clashingBookings != null){
                for(Booking booking : clashingBookings){
                    if(booking.getPackageId().equals(clientPackage.getId())) {
                        roomIds.addAll(booking.getRooms());
                    }
                }
            }
            bookedRooms.put(clientPackage.getId(), roomIds);
        }
        return bookedRooms;
    }

    @Override
    public String delete(String id) {
        clientPackageRepository.findById(id).orElseThrow();
        clientPackageRepository.deleteById(id);
        return "deleted";
    }

    @Override
    public List<String> getAvailableRoomsByClientPackage(String clientId, String packageId, Date checkIn, Date checkOut) {
        Map<String, Set<String>> bookedRoomsByClientPackages = getBookedRoomsByClientPackages(clientId, checkIn, checkOut);
        List<String> bookedRoomIds = new ArrayList<>(bookedRoomsByClientPackages.get(packageId));
        List<String> availableRoomIds = getRoomIdsByPackageId(packageId);
        availableRoomIds.removeAll(bookedRoomIds);
        return availableRoomIds;
    }

    private List<String> getRoomIdsByPackageId(String packageId) {
        List<String> currentRooms = new ArrayList<>();
        for (Room room : roomRepository.getRoomsByPackageId(packageId)){
            currentRooms.add(room.getId());
        }
        return currentRooms;
    }
}
