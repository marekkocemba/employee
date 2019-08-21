package com.pay.eye.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages ={"com.pay.eye.address.model","com.pay.eye.employee.model"})
@EnableJpaRepositories(basePackages ={"com.pay.eye.address.repository","com.pay.eye.employee.repository"})
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

}
