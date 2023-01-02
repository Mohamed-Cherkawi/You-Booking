package org.youbooking.root.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.youbooking.root.entities.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> { }
