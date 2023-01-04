package org.youbooking.root.services.implementations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.youbooking.root.entities.Hotel;
import org.youbooking.root.entities.Role;
import org.youbooking.root.enums.RoleEnum;
import org.youbooking.root.repositories.HotelRepository;
import org.youbooking.root.repositories.RoleRepository;
import org.youbooking.root.services.dtos.HotelDto;
import org.youbooking.root.services.interfaces.HotelServiceInterface;
import org.youbooking.root.utils.EntityMapping;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service("hotel-service") @AllArgsConstructor
public class HotelService implements HotelServiceInterface {
    private final HotelRepository hotelRepository;
    private final RoleRepository roleRepository;


    @Override
    public Set<HotelDto> getAllHotels(){
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels.stream()
                .map(EntityMapping::hotelToHotelDTO)
                .collect(Collectors.toSet());
    }
    @Override
    public HotelDto getHotel(Long id){
        Optional<Hotel> hotelOptional = hotelRepository.findById(id);
        return hotelOptional.map(EntityMapping::hotelToHotelDTO).orElse(null);
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

        if( hotelOptional.isEmpty() ){
            return null;
        }
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
    public boolean deleteHotel(Long hotelId){
        Optional<Hotel> hotel = hotelRepository.findById(hotelId);

        if( hotel.isEmpty() )
            return false;

         hotelRepository.deleteById(hotelId);

         return true;
    }

}