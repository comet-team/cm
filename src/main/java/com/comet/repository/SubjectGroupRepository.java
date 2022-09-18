package com.comet.repository;

import com.comet.model.entity.SubjectGroup;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SubjectGroupRepository extends CrudRepository<SubjectGroup, UUID> {
}