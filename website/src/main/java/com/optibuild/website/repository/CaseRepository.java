package com.optibuild.website.repository;

import com.optibuild.website.model.components.CPUCooler;
import com.optibuild.website.model.components.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CaseRepository extends JpaRepository<Case, Long> {

    List<Case> findByMaxGPULengthGreaterThanAndMaxCPUCoolerHeightGreaterThanAndMaxPSULengthGreaterThan(int GPULength, int CPUCoolerHeight, int PSULength);
}
