package com.optibuild.website.model.components;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("SSD")
public class SSD extends HardDrive{
    private Integer maxSequentialRead;
    private Integer maxSequentialWrite;
    private String memoryComponent;

    public SSD() {
    }

    public Integer getMaxSequentialRead() {
        return maxSequentialRead;
    }

    public void setMaxSequentialRead(Integer maxSequentialRead) {
        this.maxSequentialRead = maxSequentialRead;
    }

    public Integer getMaxSequentialWrite() {
        return maxSequentialWrite;
    }

    public void setMaxSequentialWrite(Integer maxSequentialWrite) {
        this.maxSequentialWrite = maxSequentialWrite;
    }

    public String getMemoryComponent() {
        return memoryComponent;
    }

    public void setMemoryComponent(String memoryComponent) {
        this.memoryComponent = memoryComponent;
    }
}
