package org.youbooking.root.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.youbooking.root.entities.Bed;

@Repository
public interface BedRepository extends JpaRepository<Bed,Long> { }
