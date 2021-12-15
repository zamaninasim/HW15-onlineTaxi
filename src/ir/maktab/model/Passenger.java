package ir.maktab.model;

import ir.maktab.model.enums.Gender;
import ir.maktab.model.enums.status.PassengerStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;
    private String phoneNumber;
    private String email;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    private String nationalId;
    private String userName;
    private int balance;
    @Enumerated(EnumType.STRING)
    private PassengerStatus passengerStatus;
    @ManyToOne(cascade = CascadeType.ALL)
    private Location location;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "passenger")
    private List<Trip> trips;



}
