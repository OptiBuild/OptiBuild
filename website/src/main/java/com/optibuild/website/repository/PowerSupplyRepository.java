package com.optibuild.website.repository;

import com.optibuild.website.model.components.PowerSupply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PowerSupplyRepository extends JpaRepository<PowerSupply, Long> {
    List<PowerSupply> findByMaxPowerGreaterThan(int power);
}
