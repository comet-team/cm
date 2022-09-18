package com.comet.repository;

import com.comet.model.entity.StudentGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudentGroupRepository extends CrudRepository<StudentGroup, UUID> {
}