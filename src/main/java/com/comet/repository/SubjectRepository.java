package com.comet.repository;

import com.comet.model.entity.Subject;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SubjectRepository extends CrudRepository<Subject, UUID> {
}