package com.pay.eye.employee.service.command;

import com.pay.eye.employee.dto.EmployeeDto;
import com.pay.eye.employee.model.Employee;
import com.pay.eye.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class EmployeeCommandService {

    private final EmployeeRepository employeeRepository;

    public EmployeeCommandService(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    public EmployeeDto saveEmployee(@Valid EmployeeDto employeeDto) {

        Employee employee = new Employee(employeeDto);
        employeeRepository.save(employee);

        return new EmployeeDto(employee);
    }

    public void updateEmployee(Long employeeId, EmployeeDto employeeDto) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found for this id : " + employeeId));

        employee.updateFields(employeeDto);
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found for this id : " + employeeId));

        employeeRepository.delete(employee);
    }
}