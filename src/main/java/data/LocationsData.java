package data;

/**
 * Created by bigdrop on 9/19/2018.
 */
public enum LocationsData {

    CHERRY_HILL ("Cherry", "NJ Cherry Hill - Hand and Stone"),
    DE_BEAR("Bear", "DE Bear - Hand and Stone"),
    PEORIA_AZ("Peoria", "AZ Peoria - Hand and Stone"),
    NAPERVILLE_IL("Naperville", "IL Naperville - Hand and Stone"),
    EDGEWATER_NJ("Edgewater", "NJ Edgewater - Hand and Stone");

    public String getShortLocationName() {
        return shortLocationName;
    }

    public String getLocationNameForMillenium() {
        return locationNameForMillenium;
    }

    private String shortLocationName;

    private String locationNameForMillenium;

    LocationsData(String shortLocationName, String locationNameForMillenium) {
        this.shortLocationName = shortLocationName;
        this.locationNameForMillenium = locationNameForMillenium;
    }
}
