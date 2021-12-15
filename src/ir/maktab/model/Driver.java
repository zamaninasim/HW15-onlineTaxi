package ir.maktab.model;

import ir.maktab.model.enums.Gender;
import ir.maktab.model.enums.status.DriverStatus;
import lombok.Data;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Driver {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Enumerated(EnumType.STRING)
    private DriverStatus driverStatus;
    @OneToOne(cascade = CascadeType.ALL)
    private Vehicle vehicle;
    @ManyToOne(cascade = CascadeType.ALL)
    private Location location;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "driver")
    private List<Trip> trips;

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                ", nationalId='" + nationalId + '\'' +
                ", userName='" + userName + '\'' +
                ", driverStatus=" + driverStatus +
                ", location=" + location +
                '}';
    }
}
