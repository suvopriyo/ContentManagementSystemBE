package com.cms.content_management_system.repo;


import com.cms.content_management_system.entity.ContentType;
import com.cms.content_management_system.entity.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContentTypeRepo extends JpaRepository<ContentType, Integer> {


}
