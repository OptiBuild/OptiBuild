package com.optibuild.website.repository;

import com.optibuild.website.model.Component;
import com.optibuild.website.model.components.CPU;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CPURepository extends JpaRepository<CPU, Long> {

    CPU findByModel(String model);

    CPU findByBrandAndModel(String brand, String model);
}
