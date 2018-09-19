package data;

/**
 * Created by bigdrop on 8/31/2018.
 */
public enum Users {
    VLADYSLAV("Lebron", "James", "vladyslav.chesalov@bigdropinc.com", "JR6GMs4ywGnew", "rdf49dw07", "JR6GMs4ywG", "0123456789",
             "3275 NW 24th Street Rd", "Miami", "Florida", "33101"),
    LEBRON("Lebron", "James", "vladyslav.chesalov+8@bigdropinc.com", "JR6GMs4ywGnew", "JR6GMs4ywG", "JR6GMs4ywG", "0123456789",
            "3275 NW 24th Street Rd", "Miami", "Florida", "33101"),
    LEBRON_UPDATE("Lebron", "James", "vladyslav.chesalov+8@bigdropinc.com", "JR6GMs4ywG", "JR6GMs4ywGnew", "JR6GMs4ywGnew", "0123456789",
            "3275 NW 24th Street Rd", "Miami", "Florida", "33101"),
    DWYANE("Dwyane", "Wade", "vladyslav.chesalov+9@bigdropinc.com", "JR6GMs4ywGnew", "JR6GMs4ywG", "JR6GMs4ywG", "9087654321",
            "322 NY 32th Street", "New York", "New York", "1001"),
    DWYANE_UPDATE("Dwyane", "Wade", "vladyslav.chesalov+9@bigdropinc.com", "JR6GMs4yw", "JR6GMs4ywGnew", "JR6GMs4ywGnew", "9087654321",
            "322 NY 32th Street", "New York", "New York", "1001"),
    ALLEN("Ray", "Allen", "vladyslav.chesalov+10@bigdropinc.com", "JR6GMs4ywnew", "JR6GMs4ywG", "JR6GMs4ywG", "1212121212",
            "322 NY 32th Street", "New York", "New York", "1001"),
    MEMBER("Vladyslav", "Chesalov", "vladyslav.chesalov+3@bigdropinc.com", "JR6GMs4ywnew", "JR6GMs4ywG", "JR6GMs4ywG", "3325546657",
            "322 NY 32th Street", "Miami", "Florida", "33101"),
    INVALID("Invalid", "Test", "vladyslav.chesalov+8@bigdropinc.com", "JR6GMs4ywG", "JR6GMs4yw", "JR6GMs4ywGnew", "9087654321",
            "3275 NW 24th Street Rd", "Miami", "Florida", "33101");

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confPassword;
    private String newPassword;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zipCode;

    public String getNewPassword() {
        return newPassword;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfPassword() {
        return confPassword;
    }

    public String getPhone() {
        return phone;
    }

    Users(String firstName, String lastName, String email, String password, String newPassword, String confPassword,
          String phone, String address, String city, String state, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.confPassword = confPassword;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.newPassword = newPassword;
    }
}
