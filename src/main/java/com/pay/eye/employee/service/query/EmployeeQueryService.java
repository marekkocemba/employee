package com.pay.eye.employee.service.query;

import com.pay.eye.employee.dto.EmployeeDto;
import com.pay.eye.employee.model.Employee;
import com.pay.eye.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeQueryService {


    private final EmployeeRepository employeeRepository;

    public EmployeeQueryService(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDto> getEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeDto::new)
                .collect(Collectors.toList());
    }

    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee =  employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found for this id : " + employeeId));
        return new EmployeeDto(employee);
    }
}
