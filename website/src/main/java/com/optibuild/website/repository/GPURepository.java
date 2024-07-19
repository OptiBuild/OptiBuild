package com.optibuild.website.repository;

import com.optibuild.website.model.components.GPU;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GPURepository extends JpaRepository<GPU, Long> {
    GPU findByModel(String model);

    GPU findByBrandAndModel(String brand, String model);
}
