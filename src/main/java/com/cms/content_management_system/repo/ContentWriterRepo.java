package com.cms.content_management_system.repo;

import com.cms.content_management_system.entity.ClientAdvertisement;
import com.cms.content_management_system.entity.ContentType;
import com.cms.content_management_system.entity.ContentWriterProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContentWriterRepo  extends JpaRepository<ContentWriterProfile, Integer> {

    Optional<ContentWriterProfile> findByEmail(String email);
}
