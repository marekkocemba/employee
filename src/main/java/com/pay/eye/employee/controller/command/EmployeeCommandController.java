package com.pay.eye.employee.controller.command;

import com.pay.eye.employee.dto.EmployeeDto;
import com.pay.eye.employee.service.command.EmployeeCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/employees")
class EmployeeCommandController {

    private final EmployeeCommandService employeeCommandService;
    private final Logger logger;

    private EmployeeCommandController(EmployeeCommandService employeeCommandService) {

        this.employeeCommandService = employeeCommandService;
        this.logger = LoggerFactory.getLogger(EmployeeCommandController.class);
    }

    @PostMapping
    public EmployeeDto saveEmployee(@Valid @RequestBody EmployeeDto employeeDto) {

        logger.info("Saving new employee");

        return employeeCommandService.saveEmployee(employeeDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateEmployee(@PathVariable(value = "id") Long employeeId, @Valid @RequestBody EmployeeDto employeeDto) {

        logger.info("Updating employee by id: "+ employeeId);

        employeeCommandService.updateEmployee(employeeId, employeeDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployee(@PathVariable(value = "id") Long employeeId){

        logger.info("Deleting employee by id: "+ employeeId);

        employeeCommandService.deleteEmployee(employeeId);
        return ResponseEntity.ok().build();
    }
}
