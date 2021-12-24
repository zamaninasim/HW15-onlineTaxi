package ir.maktab.model;

import ir.maktab.model.enums.Gender;
import ir.maktab.model.enums.status.PassengerStatus;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@ToString(callSuper = true)
public class Passenger extends User {
    private int balance;
    @Enumerated(EnumType.STRING)
    private PassengerStatus passengerStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "passenger")
    private List<Trip> trips;

    @Override
    public String toString() {
        super.toString();
        return "Passenger{" +
                "balance=" + balance +
                ", passengerStatus=" + passengerStatus +
                '}';
    }
}
