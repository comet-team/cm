package com.comet.repository;

import com.comet.model.entity.SubjectGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SubjectGroupRepository extends CrudRepository<SubjectGroup, UUID> {
}