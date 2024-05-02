package org.prash.model;

import com.fasterxml.jackson.annotation.*;

import java.util.List;

/**
 * Project: PojoFactory
 * Author: bittu
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "cityList"
})
public class AddressList {

    @JsonProperty("cityList")
    private List<Address> addresses;

    public AddressList() {
    }

    public AddressList(List<Address> addresses) {
        this.addresses = addresses;
    }

    @JsonProperty("cityList")
    public List<Address> getAddresses() {
        return addresses;
    }

    @JsonProperty("cityList")
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

}
