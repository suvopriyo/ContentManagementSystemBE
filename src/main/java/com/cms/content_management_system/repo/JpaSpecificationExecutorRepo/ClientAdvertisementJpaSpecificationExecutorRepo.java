package com.cms.content_management_system.repo.JpaSpecificationExecutorRepo;


import com.cms.content_management_system.entity.ClientAdvertisement;
import com.cms.content_management_system.entity.ContentType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClientAdvertisementJpaSpecificationExecutorRepo extends JpaRepository<ClientAdvertisement, Integer>, JpaSpecificationExecutor<ClientAdvertisement> {
}

