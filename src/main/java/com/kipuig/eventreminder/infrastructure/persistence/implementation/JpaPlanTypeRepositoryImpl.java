package com.kipuig.eventreminder.infrastructure.persistence.implementation;

import com.kipuig.eventreminder.application.interfaces.PlanTypeRepository;
import com.kipuig.eventreminder.domain.entities.PlanType;
import com.kipuig.eventreminder.infrastructure.persistence.interfaces.JpaPlanTypeRepository;
import com.kipuig.eventreminder.infrastructure.persistence.mappers.PlanTypeMapper;
import java.util.Optional;
import java.util.UUID;

public class JpaPlanTypeRepositoryImpl implements PlanTypeRepository {

    private final JpaPlanTypeRepository jpaRepository;

    public JpaPlanTypeRepositoryImpl(JpaPlanTypeRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<PlanType> getPlanTypeById(UUID id) {
        return jpaRepository.findById(id)
                .map(user -> PlanTypeMapper.toDomain(user));
    }
}
