package org.youbooking.root.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.youbooking.root.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> { }
