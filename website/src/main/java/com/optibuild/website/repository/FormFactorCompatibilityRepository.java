package com.optibuild.website.repository;

import com.optibuild.website.model.components.FormFactorCompatibility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormFactorCompatibilityRepository extends JpaRepository<FormFactorCompatibility, Long> {
    FormFactorCompatibility findByFormFactorType(String formFactor);
}
