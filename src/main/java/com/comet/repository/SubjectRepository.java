package com.comet.repository;

import com.comet.model.entity.StudentGroup;
import com.comet.model.entity.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, UUID> {
}