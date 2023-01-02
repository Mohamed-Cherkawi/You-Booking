package org.youbooking.root.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.youbooking.root.entities.BedRoom;

@Repository
public interface BedRoomRepository extends JpaRepository<BedRoom,Long> { }
