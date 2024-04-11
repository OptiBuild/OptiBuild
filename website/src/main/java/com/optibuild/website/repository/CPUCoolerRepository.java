package com.optibuild.website.repository;

import com.optibuild.website.model.components.CPUCooler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CPUCoolerRepository extends JpaRepository<CPUCooler, Long> {

}
