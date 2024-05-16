package com.optibuild.website.repository;

import com.optibuild.website.model.components.RAM;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface RAMRepository extends JpaRepository<RAM, Long> {
    List<RAM> findBySize(int size);

    List<RAM> findBySizeAndDDRVersion(int storage, int DDRVersion);

    List<RAM> findBySizeGreaterThanAndDDRVersion(int storage, int DDRVersion);

    List<RAM> findBySizeGreaterThan(int storage);
}
