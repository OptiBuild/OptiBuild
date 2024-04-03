package com.optibuild.website.repository;

import com.optibuild.website.model.components.Motherboard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MotherboardRepository extends JpaRepository<Motherboard, Long> {
    List<Motherboard> findBySocketAndDDRXAndClockspeedGreaterThanAndSupportNVMe(String socket, int ddr, int clockspeed, boolean nvme);
}
