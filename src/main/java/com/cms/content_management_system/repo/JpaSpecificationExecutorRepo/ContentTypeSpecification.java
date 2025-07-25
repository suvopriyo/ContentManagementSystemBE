package com.cms.content_management_system.repo.JpaSpecificationExecutorRepo;

import com.cms.content_management_system.entity.ContentType;
import com.cms.content_management_system.entity.ContentWriterProfile;
import org.springframework.data.jpa.domain.Specification;

public class ContentTypeSpecification {

    public static Specification<ContentType> fieldEquals(String fieldName, String value) {
        return (root, query, cb) -> cb.equal(root.get(fieldName), value);
    }
}