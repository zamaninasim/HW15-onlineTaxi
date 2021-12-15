package ir.maktab;

import ir.maktab.model.Driver;
import ir.maktab.model.Location;
import ir.maktab.model.Passenger;
import ir.maktab.model.Vehicle;
import ir.maktab.model.enums.Color;
import ir.maktab.model.enums.Gender;
import ir.maktab.model.enums.TypeOfVehicle;
import ir.maktab.model.enums.status.DriverStatus;
import ir.maktab.model.enums.status.PassengerStatus;
import ir.maktab.service.DriverService;
import ir.maktab.service.PassengerService;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    final static Scanner scanner = new Scanner(System.in);
    final static DriverService driverService = new DriverService();
    final static PassengerService passengerService = new PassengerService();

    public static void main(String[] args) throws SQLException, ParseException {

        boolean exit = false;
        do {
            System.out.println("********* Choose an option *********");
            System.out.println("""
                    1.Add a group of drivers\s
                    2.Add a group of passengers\s
                    3.Driver signup or login\s
                    4.Passenger signup or login\s
                    5.Show a list of drivers\s
                    6.Show a list of passengers\s
                    7.exit""");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter number of drivers:");
                    int count = scanner.nextInt();
                    for (int i = 0; i < count; i++) {
                        addDriver();
                    }
                    break;
                case 2:
                    System.out.println("Enter number of passengers:");
                    int countP = scanner.nextInt();
                    for (int i = 0; i < countP; i++) {
                        addPassenger();
                    }
                    break;
                case 3:
                    System.out.println("Username:");
                    String user_name_d = scanner.next();
                    signUpDriver(user_name_d);

                    break;

                case 4:
                    System.out.println("Username:");
                    String user_name_p = scanner.next();
                    signUpPassengers(user_name_p);
                    break;
                /*case 5:
                    System.out.println("**** all drivers info ****");
                    application.driverDao.showAllDrivers();
                    break;*/

            }
        } while (!exit);

    }

    public static void addDriver() throws ParseException {
        System.out.println("Enter driver information:" +
                " (full_name,phone_number,email,gender,date_of_birth,national_id,user_name):");
        String driverInfo = scanner.next();
        String[] driverInfoSplit = driverInfo.split(",");
        String fullName = driverInfoSplit[0];
        String phoneNumber = driverInfoSplit[1];
        String email = driverInfoSplit[2];
        Gender gender = Gender.valueOf(driverInfoSplit[3].toUpperCase());
        String dateOfBirth = driverInfoSplit[4];
        Date parseDateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth);
        String nationalId = driverInfoSplit[5];
        String username = driverInfoSplit[6];
        DriverStatus driverStatus = DriverStatus.WAITING;
        Vehicle vehicle = createVehicle();
        Location location = createLocation();

        Driver driver = new Driver();
        driver.setFullName(fullName);
        driver.setPhoneNumber(phoneNumber);
        driver.setEmail(email);
        driver.setGender(gender);
        driver.setDateOfBirth(parseDateOfBirth);
        driver.setNationalId(nationalId);
        driver.setUserName(username);
        driver.setVehicle(vehicle);
        driver.setDriverStatus(driverStatus);
        driver.setLocation(location);
        driverService.save(driver);

    }

    private static Location createLocation() {
        System.out.println("Enter driver location information:(latitude,Longitude):");
        String locationInfo = scanner.next();
        String[] locationInfoSplit = locationInfo.split(",");
        int latitude = Integer.parseInt(locationInfoSplit[0]);
        int longitude = Integer.parseInt(locationInfoSplit[1]);

        Location location = new Location();
        location.setLatitude(latitude);
        location.setLongitude(longitude);
        return location;
    }

    private static Vehicle createVehicle() {
        System.out.println("Enter driver car information:" +
                " (type_of_vehicle,color_of_vehicle,plaque_of_vehicle,model_of_vehicle):");
        String vehicleInfo = scanner.next();
        String[] vehicleInfoSplit = vehicleInfo.split(",");
        TypeOfVehicle type_of_vehicle = TypeOfVehicle.valueOf(vehicleInfoSplit[0].toUpperCase());
        Color color_of_vehicle = Color.valueOf(vehicleInfoSplit[1].toUpperCase());
        String plaque_of_vehicle = vehicleInfoSplit[2];
        String model_of_vehicle = vehicleInfoSplit[3];

        Vehicle vehicle = new Vehicle();
        vehicle.setTypeOfVehicle(type_of_vehicle);
        vehicle.setColorOfVehicle(color_of_vehicle);
        vehicle.setPlaqueOfVehicle(plaque_of_vehicle);
        vehicle.setModelOfVehicle(model_of_vehicle);
        return vehicle;
    }

    public static void addPassenger() throws ParseException {
        System.out.println("Enter passenger information:(full_name,phone_number,email,gender,date_of_birth,national_id,user_name):");
        String passengerInfo = scanner.next();
        String[] passengerInfoSplit = passengerInfo.split(",");
        String fullName = passengerInfoSplit[0];
        String phoneNumber = passengerInfoSplit[1];
        String email = passengerInfoSplit[2];
        Gender gender = Gender.valueOf(passengerInfoSplit[3].toUpperCase());
        String dateOfBirth = passengerInfoSplit[4];
        Date parseDateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth);
        String nationalId = passengerInfoSplit[5];
        String username = passengerInfoSplit[6];
        PassengerStatus userTripStatus = PassengerStatus.ABSENCE;
        int balance = 0;
        Location passengerLocation = createLocation();

        Passenger passenger = new Passenger();
        passenger.setFullName(fullName);
        passenger.setPhoneNumber(phoneNumber);
        passenger.setEmail(email);
        passenger.setGender(gender);
        passenger.setDateOfBirth(parseDateOfBirth);
        passenger.setNationalId(nationalId);
        passenger.setUserName(username);
        passenger.setPassengerStatus(userTripStatus);
        passenger.setBalance(balance);
        passenger.setLocation(passengerLocation);
        passengerService.save(passenger);
    }

    public static void signUpDriver(String username) throws ParseException {
        List<Driver> drivers = driverService.findByUsername(username);
        int size = drivers.size();
        if (size == 0) {
            System.out.println("*** You are not registered ***");
            System.out.println("1.Register \n2.Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addDriver();
                    break;
                case 2:
                    System.out.println("*** You are back to the main menu ***");
                    break;
            }
        } else {
            System.out.println("*** welcome ****");
            System.out.println("1.continue \n2.Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    //TODO
                    //driverActions(username);
                    break;
                case 2:
                    System.out.println("*** You are back to the main menu ***");
                    break;
            }
        }
    }

    public static void signUpPassengers(String username) throws ParseException {
        List<Passenger> passengers = passengerService.findByUsername(username);
        int size = passengers.size();
        if (size == 0) {
            System.out.println("*** You are not registered ***");
            System.out.println("1.Register \n2.Exit");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    addPassenger();
                    break;
                case 2:
                    System.out.println("*** You are back to the main menu ***");
                    break;
            }
        } else {
            //TODO
            //passengerActions(user_name);
        }
    }
}
