package com.optibuild.website.model.components;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("HDD")
public class HDD extends HardDrive{
    private Integer maxTransferRate;
    private Integer cache;

    public HDD() {
    }

    public Integer getMaxTransferRate() {
        return maxTransferRate;
    }

    public void setMaxTransferRate(Integer maxTransferRate) {
        this.maxTransferRate = maxTransferRate;
    }

    public Integer getCache() {
        return cache;
    }

    public void setCache(Integer cache) {
        this.cache = cache;
    }
}
