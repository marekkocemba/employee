package com.pay.eye.employee.model;

import com.pay.eye.address.model.Address;
import com.pay.eye.employee.service.EmployeeDto;
import com.pay.eye.employee.enums.Gender;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

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
    @OneToMany(mappedBy="employee", cascade = CascadeType.ALL)
    private List<Address> addresses;

    public Employee() {

    }

    public Employee(EmployeeDto employeeDto) {

        this.id = employeeDto.getId();
        updateFields(employeeDto);
    }

    public void updateFields(EmployeeDto employeeDto) {

        this.firstName = employeeDto.getFirstName();
        this.lastName = employeeDto.getLastName();
        this.age = employeeDto.getAge();
        this.gender = employeeDto.getGender();
        this.addresses = employeeDto.getAddresses()
                .stream()
                .map(address -> new Address(address, this))
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

    public List<Address> getAddresses() {
        return addresses;
    }
}
