package com.cms.content_management_system.repo.JpaSpecificationExecutorRepo;

import com.cms.content_management_system.entity.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserJpaSpecificationExecutorRepo extends JpaRepository<UserRegistration, Integer>, JpaSpecificationExecutor<UserRegistration>{
}
