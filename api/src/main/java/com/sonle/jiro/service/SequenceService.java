package com.sonle.jiro.service;

import com.sonle.jiro.domain.Status;
import com.sonle.jiro.entity.Sequence;
import com.sonle.jiro.repository.SequenceRepository;
import org.springframework.stereotype.Service;

@Service
public class SequenceService {

    private final SequenceRepository sequenceRepository;

    public SequenceService(SequenceRepository sequenceRepository) {
        this.sequenceRepository = sequenceRepository;
    }

    public Sequence initSequence() {
        return new Sequence(0);
    }

    public Sequence save(Sequence sequence) {
        return sequenceRepository.save(sequence);
    }

    public Integer nextValueOf(Long projectId, Status status) {
        return sequenceRepository.getNextByProjectId(projectId);
    }
}
