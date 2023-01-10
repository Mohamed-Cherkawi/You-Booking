package org.youbooking.root.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.youbooking.root.entities.Hotel;
import org.youbooking.root.entities.Role;
import org.youbooking.root.enums.RoleEnum;
import org.youbooking.root.repositories.HotelRepository;
import org.youbooking.root.repositories.RoleRepository;
import org.youbooking.root.services.dtos.HotelDto;
import org.youbooking.root.services.interfaces.HotelServiceInterface;
import org.youbooking.root.utils.EntityMapping;

import jakarta.transaction.Transactional;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service @RequiredArgsConstructor
public class HotelService implements HotelServiceInterface {
    private final HotelRepository hotelRepository;
    private final RoleRepository roleRepository;


    @Override // TODO: Pageable
    public Set<HotelDto> getAllHotels(){
        return hotelRepository.findAll().stream()
                .map(EntityMapping::hotelToHotelDTO)
                .collect(Collectors.toSet());
    }
    @Override
    public HotelDto getHotel(Long id){
        Hotel hotel = hotelRepository.findById(id).orElse(null);
        if(hotel == null)
            return null;

        return EntityMapping.hotelToHotelDTO(hotel);
    }
    @Override @Transactional
    public HotelDto createHotel(HotelDto hotel) {
        Hotel newHotel = EntityMapping.hotelDTOToHotel(hotel);

        Role ownerRole = roleRepository.findRoleByName(RoleEnum.HOTEL_OWNER);

        newHotel.getOwner().setRole(ownerRole);

        return EntityMapping.hotelToHotelDTO(hotelRepository.save(newHotel));
    }

    @Override @Transactional
    public HotelDto updateHotel(HotelDto hotelDto) {
        Optional<Hotel> hotelOptional = hotelRepository.findById(hotelDto.getId());

        if( hotelOptional.isEmpty() )
            return null;

        Hotel hotelToBeUpdated = hotelOptional.get();

        hotelToBeUpdated.setName(hotelDto.getName());
        hotelToBeUpdated.setAttachments(hotelDto.getAttachments());
        hotelToBeUpdated.setStatus(hotelDto.getStatus());
        hotelToBeUpdated.setAddress(hotelDto.getAddress());
        hotelToBeUpdated.setBedRooms(hotelDto.getBedRooms());
        hotelToBeUpdated.setIsApproved(hotelDto.getIsApproved());


        return EntityMapping.hotelToHotelDTO(hotelRepository.save(hotelToBeUpdated));
    }
    @Override @Transactional
    public void deleteHotel(Long hotelId){
         hotelRepository.deleteById(hotelId);
    }
}