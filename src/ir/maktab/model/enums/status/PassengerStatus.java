package ir.maktab.model.enums.status;

public enum PassengerStatus {
    ABSENCE("A"),
    WAITING("W"),
    TARVELING("T");
    private String abrr;

    PassengerStatus(String abrr) {
        this.abrr = abrr;
    }

    public static PassengerStatus getValue(String PassengerStatus) {
        switch (PassengerStatus.toLowerCase()) {
            case "absence":
                return ABSENCE;
            case "waiting":
                return WAITING;
            case "traveling":
                return TARVELING;
            default:
                return null;
        }
    }
}
