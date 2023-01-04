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

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service("hotel-service") @AllArgsConstructor
public class HotelService implements HotelServiceInterface {
    private final HotelRepository hotelRepository;
    private final RoleRepository roleRepository;

    public Set<HotelDto> getAllHotels(){
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels.stream()
                .map(EntityMapping::hotelToHotelDTO)
                .collect(Collectors.toSet());
    }
    public HotelDto getHotel(Long id){
        Hotel hotel= hotelRepository.findById(id).orElseThrow();

        return EntityMapping.hotelToHotelDTO(hotel);
    }
    @Override
    public HotelDto createHotel(HotelDto hotel) {
        Hotel newHotel = EntityMapping.hotelDTOToHotel(hotel);

        Role ownerRole = roleRepository.findRoleByName(RoleEnum.HOTEL_OWNER);

        newHotel.getOwner().setRole(ownerRole);

        return EntityMapping.hotelToHotelDTO(hotelRepository.save(newHotel));
    }
    public void deleteHotel(Long hotelId){
        hotelRepository.deleteById(hotelId);
    }
}
