package com.pay.eye.address.service;

import com.pay.eye.address.model.Address;

import java.io.Serializable;

public class AddressDto implements Serializable {

    private Long id;
    private String country;
    private String city;
    private String street;
    private String houseNumber;
    private String flatNumber;

    public AddressDto() {
;
    }

    public AddressDto(Address address) {

        this.id = address.getId();
        this.country = address.getCountry();
        this.city = address.getCity();
        this.street = address.getStreet();
        this.houseNumber = address.getHouseNumber();
        this.flatNumber = address.getFlatNumber();
    }

    public Long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }
}
