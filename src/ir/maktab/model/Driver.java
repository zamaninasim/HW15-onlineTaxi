package ir.maktab.model;

import ir.maktab.model.enums.status.DriverStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Driver extends User {
    @Enumerated(EnumType.STRING)
    private DriverStatus driverStatus;
    @OneToOne(cascade = CascadeType.ALL)
    private Vehicle vehicle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "driver")
    private List<Trip> trips;

    @Override
    public String toString() {
        super.toString();
        return "Driver{" +
                "driverStatus=" + driverStatus +
                //", vehicle=" + vehicle +
                ", trips=" + trips +
                '}';
    }
}
