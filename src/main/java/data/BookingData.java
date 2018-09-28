package data;

/**
 * Created by bigdrop on 9/28/2018.
 */
public class BookingData {

    private String currentDate;
    private String location;
    private String service;
    private String therapist;
    private String date;
    private String duration;
    private String subTotal;
    private String tax;
    private String total;

    public String getCurrentDate() {
        return currentDate;
    }

    public BookingData setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public BookingData setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getService() {
        return service;
    }

    public BookingData setService(String service) {
        this.service = service;
        return this;
    }

    public String getTherapist() {
        return therapist;
    }

    public BookingData setTherapist(String therapist) {
        this.therapist = therapist;
        return this;
    }

    public String getDate() {
        return date;
    }

    public BookingData setDate(String date) {
        this.date = date;
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public BookingData setDuration(String duration) {
        this.duration = duration;
        return this;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public BookingData setSubTotal(String subTotal) {
        this.subTotal = subTotal;
        return this;
    }

    public String getTax() {
        return tax;
    }

    public BookingData setTax(String tax) {
        this.tax = tax;
        return this;
    }

    public String getTotal() {
        return total;
    }

    public BookingData setTotal(String total) {
        this.total = total;
        return this;
    }
}
