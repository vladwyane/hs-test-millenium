package data;

/**
 * Created by bigdrop on 9/19/2018.
 */
public enum DateTime {

    SEPTEMBER22_12PM("Sep 22", "12:00\nPM"),
    SEPTEMBER30_10AM ("Sep 10", "10:00\nAM"),
    OCTOBER11_3PM ("Oct 11", "03:00\nPM"),
    NOVEMBER23_6PM ("Nov 10", "06:00\nPM");

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    private String date;
    private String time;

    DateTime(String date, String time) {
        this.date = date;
        this.time = time;
    }
}
