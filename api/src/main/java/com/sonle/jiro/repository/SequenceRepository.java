package com.sonle.jiro.repository;

import com.sonle.jiro.entity.Sequence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface SequenceRepository extends JpaRepository<Sequence, Long> {
    @Transactional
    @Query(value = "UPDATE app_sequence SET next = next + 1 WHERE project_id = :projectId RETURNING next", nativeQuery = true)
    Integer getNextByProjectId(Long projectId);
}
