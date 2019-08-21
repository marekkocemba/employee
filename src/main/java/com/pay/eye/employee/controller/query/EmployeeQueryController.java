package com.pay.eye.employee.controller.query;

import com.pay.eye.employee.service.EmployeeDto;
import com.pay.eye.employee.service.query.EmployeeQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
class EmployeeQueryController {

    private final EmployeeQueryService employeeQueryService;
    private final Logger logger;

    private EmployeeQueryController(EmployeeQueryService employeeQueryService) {

        this.employeeQueryService = employeeQueryService;
        this.logger = LoggerFactory.getLogger(EmployeeQueryController.class);
    }

    @GetMapping
    public List<EmployeeDto> getEmployees() {

        logger.info("Fetching list of employees");

        return employeeQueryService.getEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable(value = "id") Long employeeId) {

        logger.info("Fetching employee by id: "+ employeeId);

        return employeeQueryService.getEmployeeById(employeeId);
    }
}