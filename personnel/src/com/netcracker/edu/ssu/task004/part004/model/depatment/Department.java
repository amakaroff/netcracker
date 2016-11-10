package com.netcracker.edu.ssu.task004.part004.model.depatment;

import com.netcracker.edu.ssu.task004.part004.model.depatment.employee.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алексей on 08.11.2016.
 */

public class Department {

    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.employees = new ArrayList<>();
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public Employee getEmployeeByName(String name) {
        for (Employee employee : employees) {
            if (employee.getName() == name) {
                return employee;
            }
        }

        return null;
    }

    public void addEmployee(Employee employee) {
        if (employee == null) {
            throw new NullPointerException("Employee is null");
        }
        employees.add(employee);
    }
}
