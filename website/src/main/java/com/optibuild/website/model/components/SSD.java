package com.optibuild.website.model.components;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("SSD")
public class SSD extends HardDrive{
    private int maxSequentialRead;
    private int maxSequentialWrite;
    private String memoryComponent;

    public SSD() {
    }

    public int getMaxSequentialRead() {
        return maxSequentialRead;
    }

    public void setMaxSequentialRead(int maxSequentialRead) {
        this.maxSequentialRead = maxSequentialRead;
    }

    public int getMaxSequentialWrite() {
        return maxSequentialWrite;
    }

    public void setMaxSequentialWrite(int maxSequentialWrite) {
        this.maxSequentialWrite = maxSequentialWrite;
    }

    public String getMemoryComponent() {
        return memoryComponent;
    }

    public void setMemoryComponent(String memoryComponent) {
        this.memoryComponent = memoryComponent;
    }
}
