package com.netcracker.edu.ssu.task004.part004.model;

import com.netcracker.edu.ssu.task004.part004.model.depatment.Department;
import com.netcracker.edu.ssu.task004.part004.model.depatment.employee.Employee;
import com.netcracker.edu.ssu.task004.part004.model.project.Chief.Chief;
import com.netcracker.edu.ssu.task004.part004.model.project.Project;
import com.netcracker.edu.ssu.task004.part004.model.project.customer.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алексей on 10.11.2016.
 */

public class Company {

    private List<Department> departments;
    private List<Project> projects;

    public Company() {
        this.departments = new ArrayList<>();
        this.projects = new ArrayList<>();
    }

    public List<Department> getDepartments() {
        return new ArrayList<>(departments);
    }

    public List<Project> getProjects() {
        return new ArrayList<>(projects);
    }

    public void addDepartments(String departmentName) {
        if (departmentName == null) {
            throw new NullPointerException("Department name is empty");
        }
        departments.add(new Department(departmentName));
    }

    public void addEmployee(String name, String departmentName) {
        if (name == null || departmentName == null) {
            throw new NullPointerException("Name is empty");
        }

        if (departmentName.isEmpty()) {
            System.out.println("Departments is empty");
        }

        for (Department value : departments) {
            if (value.getName().equals(departmentName)) {
                value.addEmployee(new Employee(name));
                return;
            }
        }
        System.out.println("Wrong department name");
    }

    public void addProject(String projectName, String customerName, String chiefName) {
        if (projectName == null || chiefName == null || customerName == null) {
            throw new NullPointerException("Name is empty");
        }

        projects.add(new Project(projectName, new Chief(chiefName), new Customer(customerName)));
    }

    public void connectEmployeeToProject(String employeeName, String projectName) {
        Employee employee = getEmployeeByName(employeeName);
        Project project = findProjectByName(projectName);
        if (project != null) {
            project.addEmployee(employee);
        } else {
            System.out.println("Project is not found or Employee is not found");
        }
    }
    
    public Employee getEmployeeByName(String employeeName) {
        if (employeeName == null) {
            throw new NullPointerException("Department name is empty");
        }

        for (Department department : departments) {
            Employee employee = department.getEmployeeByName(employeeName);
            if (employee != null) {
                return employee;
            }
        }
        return null;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        for (Department department : departments) {
            employees.addAll(department.getEmployees());
        }
        return employees;
    }

    public Project findProjectByName(String projectName) {
        for (Project project : projects) {
            if (project.getName().equals(projectName)) {
                return project;
            }
        }

        return null;
    }

    public Department findDepartmentByName(String departmentName) {
        for (Department department : departments) {
            if (department.getName().equals(departmentName)) {
                return department;
            }
        }
        return null;
    }
}
