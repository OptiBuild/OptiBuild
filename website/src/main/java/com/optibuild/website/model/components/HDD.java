package com.optibuild.website.model.components;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("HDD")
public class HDD extends HardDrive{
    private int maxTransferRate;
    private int cache;
}
