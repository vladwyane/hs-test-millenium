package data;

/**
 * Created by bigdrop on 9/3/2018.
 */
public class UsersData {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confPassword;
    private String phone;
    private String location;

    public UsersData setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UsersData setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UsersData setEmail(String email) {
        this.email = email;
        return this;
    }

    public UsersData setPassword(String password) {
        this.password = password;
        return this;
    }

    public UsersData setConfPassword(String confPassword) {
        this.confPassword = confPassword;
        return this;
    }

    public UsersData setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public UsersData setLocation(String location) {
        this.location = location;
        return this;
    }

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

    @Override
    public String toString() {
        return "UserData{" + "Email = '" + email + "'}";
    }
}
