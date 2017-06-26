package APIMessenger.Model;

public class User {
    private int id;
    private String name;
    private String surname;
    private String address;
    private String telephone;
    private String city;
    private String country;
    private String province;
    private String password;

    public User(int id, String name, String surname, String address, String telephone, String city, String province, String country, String password){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.telephone = telephone;
        this.city = city;
        this.province = province;
        this.country = country;
        this.password = password;
    }

    public User(String name, String surname, String address, String telephone, String city, String province, String country, String password){
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.telephone = telephone;
        this.city = city;
        this.province = province;
        this.country = country;
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
