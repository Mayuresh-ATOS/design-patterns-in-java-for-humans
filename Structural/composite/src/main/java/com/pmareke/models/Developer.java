package com.pmareke.models;

import com.pmareke.interfaces.Employee;

public class Developer implements Employee {
    protected String name;
    protected float salary;
    protected String[] roles = {};

    public Developer(String name, float salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public float getSalary() {
        return this.salary;
    }

    @Override
    public String[] getRoles() {
        return this.roles;
    }
}
