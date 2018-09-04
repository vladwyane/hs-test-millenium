package data;

/**
 * Created by bigdrop on 8/31/2018.
 */
public enum Users {

    LEBRON("Lebron", "James", "vladyslav.chesalov+8@bigdropinc.com", "JR6GMs4ywG", "JR6GMs4ywG", "0123456789", "Cherry"),
    DWYANE("Dwyane", "Wade", "vladyslav.chesalov+9@bigdropinc.com", "JR6GMs4ywG", "JR6GMs4ywG", "9087654321", "Bear");

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confPassword;
    private String phone;
    private String location;

    public String getLocation() {
        return location;
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

    Users(String firstName, String lastName, String email, String password, String confPassword, String phone, String location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.confPassword = confPassword;
        this.phone = phone;
        this.location = location;
    }
}
