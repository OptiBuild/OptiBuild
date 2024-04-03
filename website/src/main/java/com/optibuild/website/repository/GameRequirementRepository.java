package com.optibuild.website.repository;

import com.optibuild.website.model.GameRequirement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRequirementRepository extends JpaRepository<GameRequirement, Long> {
    GameRequirement findByNameAndPcRequirements(String name, String pcRequirement);
}
