package org.youbooking.root.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.youbooking.root.entities.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser,Long> { }
