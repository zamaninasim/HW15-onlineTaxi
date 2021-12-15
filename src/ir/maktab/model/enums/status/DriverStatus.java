package ir.maktab.model.enums.status;

public enum DriverStatus {
    ABSENCE("A"),
    WAITING("W"),
    TARVELING("T");
    private String abrr;

    DriverStatus(String abrr) {
        this.abrr = abrr;
    }
}
