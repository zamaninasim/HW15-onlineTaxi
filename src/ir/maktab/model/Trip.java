package ir.maktab.model;

import ir.maktab.model.enums.PaymentType;
import ir.maktab.model.enums.status.TripStatus;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Driver driver;
    @ManyToOne(cascade = CascadeType.ALL)
    private Passenger passenger;
    //private Location originLocation;
    @ManyToOne
    private Location destinationLocation;
    private int price;
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
    @Enumerated(EnumType.STRING)
    private TripStatus tripStatus;
}
