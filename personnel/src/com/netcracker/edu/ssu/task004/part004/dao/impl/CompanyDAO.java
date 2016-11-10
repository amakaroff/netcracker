package com.netcracker.edu.ssu.task004.part004.dao.impl;

import com.netcracker.edu.ssu.task004.part004.dao.api.DAO;
import com.netcracker.edu.ssu.task004.part004.model.Company;
import com.netcracker.edu.ssu.task004.part004.model.depatment.employee.Employee;
import com.netcracker.edu.ssu.task004.part004.model.project.Chief.Chief;
import com.netcracker.edu.ssu.task004.part004.model.project.Project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Алексей on 08.11.2016.
 */
public class CompanyDAO implements DAO {

    private Company company;

    public CompanyDAO(Company company) {
        this.company = company;
    }

    @Override
    public List<Employee> getEmployeesFromSelectDepartment(String departmentName) {
        return company.findDepartmentByName(departmentName).getEmployees();
    }

    @Override
    public List<Project> getProjectsWhichInvolvesSelectEmployee(String employeeName) {
        List<Project> projects = new ArrayList<>();

        for (Project project : company.getProjects()) {
            if (project.containsEmployee(employeeName))
                projects.add(project);
        }

        return projects;
    }

    @Override
    public List<Employee> getEmployeesFromSelectDepartmentOutOfEmployment(String departmentName) {
        List<Employee> employees = new ArrayList<>();
        boolean isWorking = false;
        List<Project> projects = company.getProjects();

        for (Employee employee : company.findDepartmentByName(departmentName).getEmployees()) {
            for (Project project : projects) {
                if (project.containsEmployee(employee.getName())) {
                    isWorking = true;
                    break;
                }
            }
            if (!isWorking) {
                employees.add(employee);
            }
            isWorking = false;
        }

        return employees;
    }

    @Override
    public List<Employee> getEmployeesOutOfEmployment() {
        List<Employee> employees = new ArrayList<>();
        boolean isWorking = false;
        List<Project> projects = company.getProjects();

        for (Employee employee : company.getAllEmployees()) {
            for (Project project : projects) {
                if (project.containsEmployee(employee.getName())) {
                    isWorking = true;
                    break;
                }
            }
            if (!isWorking) {
                employees.add(employee);
            }
            isWorking = false;
        }

        return employees;
    }

    @Override
    public List<Employee> getEmployeesSelectChief(String chiefName) {
        Set<Employee> employees = new HashSet<>();

        for (Project project : company.getProjects()) {
            if (project.getChief().getName().equals(chiefName)) {
                employees.addAll(project.getEmployees());
            }
        }

        return new ArrayList<>(employees);
    }

    @Override
    public List<Chief> getChiefsSelectEmployee(String employee) {
        Set<Chief> chiefs = new HashSet<>();

        for (Project project : company.getProjects()) {
            if (project.containsEmployee(employee)) {
                chiefs.add(project.getChief());
            }
        }

        return new ArrayList<>(chiefs);
    }

    @Override
    public List<Employee> getEmployeesWorkWithSelectEmployee(String employee) {
        Set<Employee> employees = new HashSet<>();
        for (Project project : company.getProjects()) {
            if (project.containsEmployee(employee)) {
                employees.addAll(project.getEmployees());
            }
        }

        employees.remove(company.getEmployeeByName(employee));
        return new ArrayList<>(employees);
    }

    @Override
    public List<Project> getProjectsFromSelectCustomer(String customer) {
        List<Project> projects = new ArrayList<>();

        for (Project project : company.getProjects()) {
            if (project.getCustomer().getName().equals(customer)) {
                projects.add(project);
            }
        }

        return projects;
    }

    @Override
    public List<Employee> getEmployeesWorkAtSelectCustomer(String customer) {
        Set<Employee> employees = new HashSet<>();
        for (Project project : company.getProjects()) {
            if (project.getCustomer().getName().equals(customer)) {
                employees.addAll(project.getEmployees());
            }
        }

        return new ArrayList<>(employees);
    }
}
