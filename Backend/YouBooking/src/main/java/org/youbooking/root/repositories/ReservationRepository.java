package org.youbooking.root.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.youbooking.root.entities.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {}