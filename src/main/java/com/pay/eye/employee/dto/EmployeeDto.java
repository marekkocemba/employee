package com.pay.eye.employee.dto;

import com.pay.eye.employee.enums.Gender;
import com.pay.eye.employee.model.Employee;

public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Gender gender;

    public EmployeeDto(Employee employee) {

        this.id = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.age = employee.getAge();
        this.gender = employee.getGender();
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
}
