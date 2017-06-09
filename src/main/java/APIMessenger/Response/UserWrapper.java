package APIMessenger.Response;
import com.fasterxml.jackson.annotation.JsonProperty;

/* En esta clase no se muestra el password del usuario*/

public class UserWrapper {
    @JsonProperty private String name;
    @JsonProperty private String surname;
    @JsonProperty private String address;
    @JsonProperty private String telephone;
    @JsonProperty private String city;
    @JsonProperty private String province;
    @JsonProperty private String country;

    public UserWrapper(String name, String surname, String address, String telephone, String city, String province, String country){
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.telephone = telephone;
        this.city = city;
        this.province = province;
        this.country = country;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
}
