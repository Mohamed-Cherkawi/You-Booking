package org.youbooking.root.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.youbooking.root.entities.HotelOffer;

@Repository
public interface HotelOfferRepository extends JpaRepository<HotelOffer,Long> {}
