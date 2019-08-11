package com.pmareke.models;

import com.pmareke.interfaces.Employee;

import java.util.ArrayList;
import java.util.List;

public class Organization {

    protected List<Employee> employees = new ArrayList<Employee>();

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public float getNetSalaries() {
        return employees.stream()
                .map(Employee::getSalary)
                .reduce(0f, (a, b) -> a + b);
    }
}
