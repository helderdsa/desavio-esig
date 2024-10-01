package com.esig.helder.desafio.backend.utils;

import com.esig.helder.desafio.backend.enums.Priority;
import com.esig.helder.desafio.backend.enums.Status;
import com.esig.helder.desafio.backend.model.Task;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class TaskSpecification {

    public static Specification<Task> hasTitle(String title) {
        return (root, query, criteriaBuilder) -> 
            title == null ? null : criteriaBuilder.like(root.get("title"), "%" + title + "%");
    }

    public static Specification<Task> hasStatus(Status status) {
        return (root, query, criteriaBuilder) -> 
            status == null ? null : criteriaBuilder.equal(root.get("status"), status);
    }

    public static Specification<Task> hasPriority(Priority priority) {
        return (root, query, criteriaBuilder) -> 
            priority == null ? null : criteriaBuilder.equal(root.get("priority"), priority);
    }

    public static Specification<Task> hasDescription(String description) {
        return (root, query, criteriaBuilder) -> 
            description == null ? null : criteriaBuilder.like(root.get("description"), "%" + description + "%");
    }

    public static Specification<Task> hasDeadline(LocalDate deadline) {
        return (root, query, criteriaBuilder) -> 
            deadline == null ? null : criteriaBuilder.equal(root.get("deadline"), deadline);
    }

    public static Specification<Task> hasOwnerId(Long ownerId) {
        return (root, query, criteriaBuilder) -> 
            ownerId == null ? null : criteriaBuilder.equal(root.get("owner").get("id"), ownerId);
    }
}
