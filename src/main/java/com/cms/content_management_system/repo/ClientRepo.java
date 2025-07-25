package com.cms.content_management_system.repo;

import com.cms.content_management_system.entity.ClientAdvertisement;
import com.cms.content_management_system.entity.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<ClientAdvertisement, Integer> {
}
