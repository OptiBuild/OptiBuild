package com.optibuild.website.model.components;

import com.optibuild.website.model.Component;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CPU extends Component {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int coreNum;
    private int threadNum;
    private float upperClock;
    private float lowerClock;
    private String socketType;
    private int size;
    private int L3Cache;
    private int TDP;
}
