package com.netcracker.edu.ssu.task004.part004.model.project;

import com.netcracker.edu.ssu.task004.part004.model.depatment.employee.Employee;
import com.netcracker.edu.ssu.task004.part004.model.project.Chief.Chief;
import com.netcracker.edu.ssu.task004.part004.model.project.customer.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алексей on 08.11.2016.
 */

public class Project {

    private String name;
    private Chief chief;
    private Customer customer;
    private List<Employee> employees;

    public Project(String name, Chief chief, Customer customer) {
        this.name = name;
        this.chief = chief;
        this.customer = customer;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public String getName() {
        return name;
    }

    public Chief getChief() {
        return chief;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public boolean containsEmployee(String employeeName) {
        for (Employee employee : employees) {
            if (employee.getName().equals(employeeName)) {
                return true;
            }
        }
        return false;
    }
}
