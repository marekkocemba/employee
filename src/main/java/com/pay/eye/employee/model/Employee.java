package com.pay.eye.employee.model;

import com.pay.eye.employee.dto.EmployeeDto;
import com.pay.eye.employee.enums.Gender;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Employee(EmployeeDto employeeDto) {

        this.id = employeeDto.getId();
        updateFields(employeeDto);
    }

    public void updateFields(EmployeeDto employeeDto) {

        this.firstName = employeeDto.getFirstName();
        this.lastName = employeeDto.getLastName();
        this.age = employeeDto.getAge();
        this.gender = employeeDto.getGender();
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
