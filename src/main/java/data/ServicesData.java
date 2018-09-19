package data;

/**
 * Created by bigdrop on 9/12/2018.
 */
public enum ServicesData {

    NMFC50 ("Men's Facial Clarity", "1 hour"),
    MFC ("Men's Facial Clarity", "15 min"),
    NM25 ("Massage", "30 min"),
    NM50 ("Massage", "1 hour"),
    NM80 ("Massage", "1 hour 30 min"),
    NMTFC ("Teen Facial Clarity", "1 hour"),
    INTROHS50 ("Hot Stone Massage", "1 hour");

    public String getServiceName() {
        return serviceName;
    }

    public String getDuration() {
        return duration;
    }

    private String serviceName;
    private String duration;


    ServicesData(String serviceName, String duration) {
        this.serviceName = serviceName;
        this.duration = duration;
    }

}
