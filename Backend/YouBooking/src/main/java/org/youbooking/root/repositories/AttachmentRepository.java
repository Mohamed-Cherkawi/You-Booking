package org.youbooking.root.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.youbooking.root.entities.Attachment;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment,Long> { }
