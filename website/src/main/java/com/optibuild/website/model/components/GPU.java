package com.optibuild.website.model.components;

import com.optibuild.website.model.Component;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class GPU extends Component {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int codaCoreNum;
    private int baseClock;
    private int boostClock;
    private int memory;
    private int memoryClock;
    private int requestSystemPower;
    private int length;

}
