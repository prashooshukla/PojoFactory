package org.prash.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Project: PojoFactory
 * Author: bittu
 *
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "StreetName",
        "Pincode",
        "City",
        "District",
        "State"
})

public class Address {

    private static final String COUNTRY = "India";

    @JsonProperty("StreetName")
    private String streetName;
    @JsonProperty("Pincode")
    private String pincode;
    @JsonProperty("City")
    private String city;
    @JsonProperty("District")
    private String district;
    @JsonProperty("State")
    private String state;

    public Address() {
    }

    public Address(String streetAddress, String city, String state, String pincode) {
        this.streetName = streetAddress;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetAddress='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + pincode + '\'' +
                '}';
    }
}
