package data;

/**
 * Created by bigdrop on 9/12/2018.
 */
public enum ServicesData {

    NMFC50 ("Men's Facial Clarity", "1 hour", "FACIALS - CLARITY:NONMEMBER", "NMFC50", "Facial", "120"),
    MFC ("Men's Facial Clarity", "15 min", "FACIALS - CLARITY:MEMBER", "MFC", "Facial", "35"),
    NM25 ("Massage", "30 min", "MASSAGE:NONMEMBER", "NM25", "Massage", "44"),
    NM50 ("Massage", "1 hour", "MASSAGE:NONMEMBER", "NM50", "Massage", "63"),
    NM80 ("Massage", "1 hour 30 min", "MASSAGE:NONMEMBER", "NM80", "Massage", "86"),
    NMTFC ("Teen Facial Clarity", "1 hour", "FACIALS - CLARITY:NONMEMBER", "NMTFC", "Facial", "81"),
    NCHS80("Men's Facial", "1 hour 30 min", "FACIALS - CLARITY:NONMEMBER", "NCHS80", "Facial", "99"),
    INTROHS50 ("Hot Stone Massage", "1 hour", "MASSAGE:NONMEMBER", "INTROHS50", "Massage", "102");

    public String getServiceName() {
        return serviceName;
    }

    public String getDuration() {
        return duration;
    }

    public String getClassName() {
        return className;
    }

    public String getCodeService() {
        return codeService;
    }

    public String getFormulaType() {
        return formulaType;
    }

    public String getPrice() {
        return price;
    }

    private String serviceName;
    private String duration;
    private String className;
    private String codeService;
    private String formulaType;
    private String price;

    ServicesData(String serviceName, String duration, String className, String codeService, String formulaType, String price) {
        this.serviceName = serviceName;
        this.duration = duration;
        this.className = className;
        this.codeService = codeService;
        this.formulaType = formulaType;
        this.price = price;
    }

}
