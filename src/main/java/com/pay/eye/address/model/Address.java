package com.pay.eye.address.model;

import com.pay.eye.address.service.AddressDto;
import com.pay.eye.employee.model.Employee;

import javax.persistence.*;

@Entity
@Table(name="addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String country;
    private String city;
    private String street;
    @Column(name= "house_number")
    private String houseNumber;
    @Column(name= "flat_number")
    private String flatNumber;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Address() {
    }

    public Address(AddressDto addressDto, Employee employee) {
        this.id = addressDto.getId();
        this.country = addressDto.getCountry();
        this.city = addressDto.getCity();
        this.street = addressDto.getStreet();
        this.houseNumber = addressDto.getHouseNumber();
        this.flatNumber = addressDto.getFlatNumber();
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
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
}
