package com.pay.eye.employee.service;

import com.pay.eye.address.service.AddressDto;
import com.pay.eye.employee.enums.Gender;
import com.pay.eye.employee.model.Employee;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDto implements Serializable {

    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private Integer age;
    private Gender gender;
    private List<AddressDto> addresses;

    public EmployeeDto() {

    }

    public EmployeeDto(Employee employee) {

        this.id = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.age = employee.getAge();
        this.gender = employee.getGender();
        this.addresses = employee.getAddresses()
                .stream()
                .map(AddressDto::new)
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public List<AddressDto> getAddresses() {
        return addresses;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setAddresses(List<AddressDto> addresses) {
        this.addresses = addresses;
    }
}
