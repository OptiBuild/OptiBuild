package com.optibuild.website.model.components;

import com.optibuild.website.model.Component;
import jakarta.persistence.*;
import lombok.*;

import java.net.Socket;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CPUCooler extends Component {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int size;
//    private String CPUSocket;
    @OneToMany(mappedBy = "model")
    private Set<SocketCompatibility> socketCompatibilitySet;
    private int height;
    private boolean RGB;
    private boolean addressable;

//    public CPUCooler(long id, String brand, String model, int price, int score, int size, ArrayList<String> CPUSocket, int height, boolean RGB, boolean addressable) {
//        super(id, brand, model, price, score);
//        this.size = size;
//        this.CPUSocket = CPUSocket;
//        this.height = height;
//        this.RGB = RGB;
//        this.addressable = addressable;
//    }
//
    public boolean checkCPUCoolerCompatibility (CPU model) {
        boolean compatible = false;
        // TODO

        return compatible;
    }

}
