package com.example.jdbcsecurity;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee, long id);
    void deleteEmployee(long id);
}
