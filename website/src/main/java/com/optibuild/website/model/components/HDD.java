package com.optibuild.website.model.components;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("HDD")
public class HDD extends HardDrive{
    private int maxTransferRate;
    private int cache;

    public HDD() {
    }

    public int getMaxTransferRate() {
        return maxTransferRate;
    }

    public void setMaxTransferRate(int maxTransferRate) {
        this.maxTransferRate = maxTransferRate;
    }

    public int getCache() {
        return cache;
    }

    public void setCache(int cache) {
        this.cache = cache;
    }
}
