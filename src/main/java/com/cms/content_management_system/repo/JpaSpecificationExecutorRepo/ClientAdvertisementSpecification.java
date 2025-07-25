package com.cms.content_management_system.repo.JpaSpecificationExecutorRepo;

import com.cms.content_management_system.entity.ClientAdvertisement;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClientAdvertisementSpecification {

    public static Specification<ClientAdvertisement> build(Map<String, String> filters) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            filters.forEach((field, value) -> {
                // Optional: Add field whitelist for security
                if (value != null && !value.isEmpty()) {
                    predicates.add(cb.equal(root.get(field), value));
                }
            });

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}