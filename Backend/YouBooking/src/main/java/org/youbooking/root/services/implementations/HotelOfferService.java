package org.youbooking.root.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.youbooking.root.entities.Hotel;
import org.youbooking.root.entities.HotelOffer;
import org.youbooking.root.repositories.HotelOfferRepository;
import org.youbooking.root.repositories.HotelRepository;
import org.youbooking.root.services.dtos.HotelOfferDto;
import org.youbooking.root.services.interfaces.HotelOfferServiceInterface;
import org.youbooking.root.utils.EntityMapping;

import java.util.Set;
import java.util.stream.Collectors;

@Service @RequiredArgsConstructor
public class HotelOfferService implements HotelOfferServiceInterface {
    private final HotelOfferRepository hotelOfferRepository;
    private final HotelRepository hotelRepository;

    @Override // TODO Pageable
    public Set<HotelOfferDto> getAllOffers() {
        return hotelOfferRepository.findAll().stream()
                .map(EntityMapping::offerToOfferDto)
                .collect(Collectors.toSet());
    }

    @Override
    public HotelOfferDto getOfferById(Long id) {
        HotelOffer hotelOffer = hotelOfferRepository.findById(id).orElse(null);
        if(hotelOffer == null)
            return null;

        return EntityMapping.offerToOfferDto(hotelOffer);
    }

    @Override @Transactional
    public HotelOfferDto saveOffer(HotelOfferDto hotelOfferDto) {
        Hotel hotel = hotelRepository.findById(hotelOfferDto.getHotel().getId()).orElseThrow();

        HotelOffer hotelOffer = EntityMapping.offerDtoToOffer(hotelOfferDto);

        hotelOffer.setHotel(hotel);

        return EntityMapping.offerToOfferDto(hotelOfferRepository.save(hotelOffer));
    }

    @Override @Transactional
    public void deleteOffer(Long offerId) {
         hotelOfferRepository.deleteById(offerId);
    }
}
