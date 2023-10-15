package com.example.jdbcsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findEmployeeById(id);

        return optionalEmployee.orElseThrow();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee, long id) {
        Employee employee1 = getEmployeeById(id);
        employee1.setName(employee.getName());
        employee1.setDepartment(employee.getDepartment());
        employee1.setAddress(employee.getAddress());
        employee1.setDesignation(employee.getDesignation());
        employeeRepository.save(employee1);
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.delete(getEmployeeById(id));
    }
}
