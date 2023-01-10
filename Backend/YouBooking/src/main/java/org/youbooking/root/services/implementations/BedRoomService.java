package org.youbooking.root.services.implementations;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.youbooking.root.entities.BedRoom;
import org.youbooking.root.enums.BedRoomStateEnum;
import org.youbooking.root.repositories.BedRoomRepository;
import org.youbooking.root.services.dtos.BedRoomDto;
import org.youbooking.root.services.interfaces.BedRoomServiceInterface;
import org.youbooking.root.utils.EntityMapping;
import org.youbooking.root.utils.StatusMapping;

import java.util.Optional;

@Service @RequiredArgsConstructor
public class BedRoomService implements BedRoomServiceInterface {
    private final BedRoomRepository bedRoomRepository;


    @Override @Transactional
    public BedRoomDto updateStatus(StatusMapping<Long, BedRoomStateEnum> statusMapping) {
        Optional<BedRoom> bedRoom = bedRoomRepository.findById(statusMapping.getId());

        if( bedRoom.isEmpty() )
            return null;

        bedRoom.get().setStatus(statusMapping.getStatus());

        return EntityMapping.bedRoomToBedRoomDTO(bedRoomRepository.save(bedRoom.get()));
    }
}
