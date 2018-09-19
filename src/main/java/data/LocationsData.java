package data;

/**
 * Created by bigdrop on 9/19/2018.
 */
public enum LocationsData {

    CHERRY_HILL ("Cherry"),
    DE_BEAR("Bear");

    public String getLocationName() {
        return locationName;
    }

    private String locationName;

    LocationsData(String locationName) {
        this.locationName = locationName;
    }
}
