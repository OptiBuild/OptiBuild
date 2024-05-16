package com.optibuild.website.repository;

import com.optibuild.website.model.components.HDD;
import com.optibuild.website.model.components.HardDrive;
import com.optibuild.website.model.components.SSD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HardDriveRepository extends JpaRepository<HardDrive, Long> {
    // Custom query to find HDD entities by capacity
    @Query("SELECT h FROM HardDrive h WHERE TYPE(h) = HDD AND h.capacity = ?1")
    List<HDD> findHDDByCapacity(String capacity);

    // Custom query to find SSD entities by capacity
    @Query("SELECT s FROM HardDrive s WHERE TYPE(s) = SSD AND s.capacity = ?1 AND s.hdInterface = ?2")
    List<SSD> findSSDByCapacityAndHdInterface(String capacity, String hdInterface);

    HardDrive findBymodel(String model);
}
