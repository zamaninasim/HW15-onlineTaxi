package ir.maktab.model;

import ir.maktab.model.enums.Color;
import ir.maktab.model.enums.TypeOfVehicle;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private TypeOfVehicle typeOfVehicle;
    @Enumerated(EnumType.STRING)
    private Color colorOfVehicle;
    private String plaqueOfVehicle;
    private String modelOfVehicle;
}
