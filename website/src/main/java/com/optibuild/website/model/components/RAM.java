package com.optibuild.website.model.components;

import com.optibuild.website.model.Component;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RAM extends Component {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int DDRVersion;
    private int stickNum;
    private int size;
    private int clockSpeed;
    private float voltage;
    private boolean RGB;
}
