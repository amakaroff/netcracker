package com.netcracker.edu.ssu.task004.part004.dao.api;

import com.netcracker.edu.ssu.task004.part004.model.depatment.employee.Employee;
import com.netcracker.edu.ssu.task004.part004.model.project.Chief.Chief;
import com.netcracker.edu.ssu.task004.part004.model.project.Project;
import com.netcracker.edu.ssu.task004.part004.model.project.customer.Customer;

import java.util.List;

/**
 * Created by Алексей on 08.11.2016.
 */
public interface DAO {

    List<Employee> getEmployeesFromSelectDepartment(String departmentName);

    List<Project> getProjectsWhichInvolvesSelectEmployee(String employeeName);

    List<Employee> getEmployeesFromSelectDepartmentOutOfEmployment(String departmentName);

    List<Employee> getEmployeesOutOfEmployment();

    List<Employee> getEmployeesSelectChief(String chiefName);

    List<Chief> getChiefsSelectEmployee(String employee);

    List<Employee> getEmployeesWorkWithSelectEmployee(String employee);

    List<Project> getProjectsFromSelectCustomer(String customer);

    List<Employee> getEmployeesWorkAtSelectCustomer(String customer);
}
