package data;

/**
 * Created by bigdrop on 9/25/2018.
 */
public enum Franchisee {

    CHERRY_HILL ("Cherry Hill Franchisee");


    public String getFaranchiseeName() {
        return faranchiseeName;
    }

    private String faranchiseeName;

    Franchisee(String faranchiseeName) {
        this.faranchiseeName = faranchiseeName;
    }
}
