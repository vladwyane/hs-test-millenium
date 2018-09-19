package data;

/**
 * Created by bigdrop on 9/19/2018.
 */
public enum Therapist {

    ANY_EMPLOYEE ("Any Employee"),
    ANY_FEMALE ("Any Female"),
    ANY_MALE("Any Male");

    public String getTherapistSpecific() {
        return therapistSpecific;
    }

    private String therapistSpecific;

    Therapist(String therapistSpecific) {
        this.therapistSpecific = therapistSpecific;
    }
}
