package com.netcracker.edu.ssu.task004.part004;

import com.netcracker.edu.ssu.task004.part004.dao.api.DAO;
import com.netcracker.edu.ssu.task004.part004.dao.impl.CompanyDAO;
import com.netcracker.edu.ssu.task004.part004.model.Company;
import com.netcracker.edu.ssu.task004.part004.model.depatment.employee.Employee;
import com.netcracker.edu.ssu.task004.part004.model.project.Chief.Chief;
import com.netcracker.edu.ssu.task004.part004.model.project.Project;

public class Main {

    public static void main(String[] args) {
        Company company = new Company();
        company.addDepartments("Programmers");
        company.addEmployee("Alex", "Programmers");
        company.addEmployee("Peter", "Programmers");
        company.addEmployee("Sasha", "Programmers");

        company.addDepartments("Designers");
        company.addEmployee("Vasya", "Designers");
        company.addEmployee("Nikolay", "Designers");
        company.addEmployee("Misha", "Designers");

        company.addDepartments("Managers");
        company.addEmployee("Pasha", "Managers");
        company.addEmployee("Dmitriy", "Managers");
        company.addEmployee("Max", "Managers");

        company.addProject("Social Network", "Mail.ru", "Durov");
        company.addProject("Funny Game", "Zador.com", "Semankov");
        company.addProject("Boring Site", "Mail.ru", "Semankov");

        company.connectEmployeeToProject("Alex", "Social Network");
        company.connectEmployeeToProject("Sasha", "Social Network");
        company.connectEmployeeToProject("Nikolay", "Social Network");
        company.connectEmployeeToProject("Max", "Social Network");

        company.connectEmployeeToProject("Nikolay", "Funny Game");
        company.connectEmployeeToProject("Peter", "Funny Game");
        company.connectEmployeeToProject("Sasha", "Funny Game");
        company.connectEmployeeToProject("Vasya", "Funny Game");

        company.connectEmployeeToProject("Max", "Boring Site");
        company.connectEmployeeToProject("Vasya", "Boring Site");
        company.connectEmployeeToProject("Alex", "Boring Site");
        company.connectEmployeeToProject("Pasha", "Boring Site");

        DAO selecter = new CompanyDAO(company);

        System.out.println("Employee from Programmers Department");
        for (Employee employee : selecter.getEmployeesFromSelectDepartment("Programmers")) {
            System.out.println(employee.getName());
        }
        System.out.println();

        System.out.println("Project which involves employee Max");
        for (Project project : selecter.getProjectsWhichInvolvesSelectEmployee("Max")) {
            System.out.println(project.getName());
        }
        System.out.println();

        System.out.println("Manager employees without work");
        for (Employee employee : selecter.getEmployeesFromSelectDepartmentOutOfEmployment("Managers")) {
            System.out.println(employee.getName());
        }
        System.out.println();

        System.out.println("Employees without work");
        for (Employee employee : selecter.getEmployeesOutOfEmployment()) {
            System.out.println(employee.getName());
        }
        System.out.println();

        System.out.println("Employee working with Chief Semanrov");
        for (Employee employee : selecter.getEmployeesSelectChief("Semankov")) {
            System.out.println(employee.getName());
        }
        System.out.println();

        System.out.println("Chiefs Sasha");
        for (Chief chief : selecter.getChiefsSelectEmployee("Sasha")) {
            System.out.println(chief.getName());
        }
        System.out.println();

        System.out.println("Employee working with Nikolay");
        for (Employee employee : selecter.getEmployeesWorkWithSelectEmployee("Nikolay")) {
            System.out.println(employee.getName());
        }
        System.out.println();

        System.out.println("Projects for Mail.ru");
        for (Project project : selecter.getProjectsFromSelectCustomer("Mail.ru")) {
            System.out.println(project.getName());
        }
        System.out.println();

        System.out.println("Employee working at projects for Mail.ru");
        for (Employee employee : selecter.getEmployeesWorkAtSelectCustomer("Mail.ru")) {
            System.out.println(employee.getName());
        }
        System.out.println();
    }
}
