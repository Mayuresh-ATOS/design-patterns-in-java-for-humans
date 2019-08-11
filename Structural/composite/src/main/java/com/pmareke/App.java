package com.pmareke;

import com.pmareke.models.Designer;
import com.pmareke.models.Developer;
import com.pmareke.models.Organization;

public class App {
    public static void main(String[] args) {
        // Prepare the employees
        Developer john = new Developer("John Doe", 12000);
        Designer jane = new Designer("Jane Doe", 15000);

        // Add them to organization
        Organization organization = new Organization();
        organization.addEmployee(john);
        organization.addEmployee(jane);

        System.out.println("Net salaries: " + organization.getNetSalaries()); // Net Salaries: 27000
    }
}
