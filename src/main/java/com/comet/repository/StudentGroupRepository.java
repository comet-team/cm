package com.comet.repository;

import com.comet.model.entity.StudentGroup;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface StudentGroupRepository extends CrudRepository<StudentGroup, UUID> {
}