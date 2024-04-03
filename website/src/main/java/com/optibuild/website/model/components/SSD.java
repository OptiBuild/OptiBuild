package com.optibuild.website.model.components;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("SSD")
public class SSD extends HardDrive{
    private int maxSequentialRead;
    private int maxSequentialWrite;
    private String memoryComponent;
}
