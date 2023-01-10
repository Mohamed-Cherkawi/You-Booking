package org.youbooking.root.services.interfaces;

import org.youbooking.root.services.dtos.HotelOfferDto;

import java.util.Set;

public interface HotelOfferServiceInterface {
    Set<HotelOfferDto> getAllOffers();
    HotelOfferDto getOfferById(Long id);
    HotelOfferDto saveOffer(HotelOfferDto hotelOfferDto);
    void deleteOffer(Long offerId);
}
