package org.youbooking.root.services.implementations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.youbooking.root.entities.Hotel;
import org.youbooking.root.repositories.HotelRepository;
import org.youbooking.root.services.dtos.HotelDto;
import org.youbooking.root.services.interfaces.HotelServiceInterface;

@Service("hotel-service") @AllArgsConstructor
public class HotelService implements HotelServiceInterface {
    private final HotelRepository hotelRepository;

    @Override
    public HotelDto createHotel(HotelDto hotel) {
        Hotel newHotel = new Hotel();
        newHotel.setId(hotel.getId());
        newHotel.setName(hotel.getName());
        newHotel.setAddress(hotel.getAddress());
        newHotel.setOwner(hotel.getOwner());
        newHotel.setAttachments(hotel.getAttachments());
        newHotel.setBedRooms(hotel.getBedRooms());

        newHotel.setStatus(hotel.getStatus());

        hotelRepository.save(newHotel);

        return hotel;
    }
}
