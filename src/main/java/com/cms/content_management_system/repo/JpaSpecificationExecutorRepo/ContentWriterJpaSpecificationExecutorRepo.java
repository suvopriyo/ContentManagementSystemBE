package com.cms.content_management_system.repo.JpaSpecificationExecutorRepo;


import com.cms.content_management_system.entity.ContentWriterProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ContentWriterJpaSpecificationExecutorRepo extends JpaRepository<ContentWriterProfile, Integer>, JpaSpecificationExecutor<ContentWriterProfile> {
}
