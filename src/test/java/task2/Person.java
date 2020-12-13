package task2;

public class Person {

    private String email;
    private String firstname;
    private String lastname;
    private String city;
    private String country;
    private int ID;

    public Person(String email, String firstname, String lastname, String city, String country, int ID) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.city = city;
        this.country = country;
        this.ID = ID;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
