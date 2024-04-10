package com.optibuild.website.Service;

import com.optibuild.website.model.components.CPU;
import com.optibuild.website.model.components.GPU;
import com.optibuild.website.model.components.PowerSupply;
import com.optibuild.website.repository.PowerSupplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PowerSupplyService {
    private final PowerSupplyRepository powerSupplyRepository;
    @Autowired
    public PowerSupplyService (PowerSupplyRepository powerSupplyRepository) {
        this.powerSupplyRepository = powerSupplyRepository;
    }

    public PowerSupply powerSupplyModel(CPU cpu, GPU gpu) {
        int power = 149;
        if (cpu != null) {
            power += cpu.getTDP();
        }
        if(gpu != null) {
            power += gpu.getRequestSystemPower();
        }
        List<PowerSupply> powerSupplyList = powerSupplyRepository.findByMaxPowerGreaterThan(power);
        if (!powerSupplyList.isEmpty()) {
            PowerSupply powerSupply = powerSupplyList.get(0);
            for (PowerSupply ps : powerSupplyList) {
                double price = powerSupply.getPrice();
                if (ps.getPrice() < price) {
                    powerSupply = ps;
                }
            }
            return powerSupply;
        } else {
            return null;
        }
    }
}
