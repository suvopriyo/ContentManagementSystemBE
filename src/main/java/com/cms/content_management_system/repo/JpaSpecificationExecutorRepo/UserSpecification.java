package com.cms.content_management_system.repo.JpaSpecificationExecutorRepo;

import com.cms.content_management_system.entity.UserRegistration;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {

    public static Specification<UserRegistration> fieldEquals(String fieldName, String value) {
        return (root, query, cb) -> cb.equal(root.get(fieldName), value);
    }
}