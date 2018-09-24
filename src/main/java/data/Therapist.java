package data;

/**
 * Created by bigdrop on 9/19/2018.
 */
public enum Therapist {

    ANY_EMPLOYEE ("Doctor", "Therapist", "Therapist", "Any Employee"),
    VLADYSLAV ("Vladyslav", "Chesalov", "Chesalov", "Any Male"),
    MERRY("Merry", "Jane", "JANE", "Any Female");

    public String getTherapistSpecific() {
        return therapistSpecific;
    }

    public String getTherapistFirstName() {
        return therapistFirstName;
    }

    public String getTherapistLastName() {
        return therapistLastName;
    }

    public String getTherapistCode() {
        return therapistCode;
    }
    private String therapistSpecific;
    private String therapistFirstName;
    private String therapistLastName;
    private String therapistCode;

    Therapist(String therapistFirstName, String therapistLastName, String therapistCode, String therapistSpecific) {
        this.therapistFirstName = therapistFirstName;
        this.therapistLastName = therapistLastName;
        this.therapistCode = therapistCode;
        this.therapistSpecific = therapistSpecific;
    }
}
