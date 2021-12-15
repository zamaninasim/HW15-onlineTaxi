package ir.maktab.model.enums;

public enum Gender {
    FEMALE,
    MALE,
    NONE;

    public static Gender getValue(String name) {
        switch (name.toLowerCase()) {
            case "female":
                return FEMALE;
            case "male":
                return MALE;
            default:
                return NONE;
        }
    }
}
