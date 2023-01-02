package org.youbooking.root.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.youbooking.root.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> { }
