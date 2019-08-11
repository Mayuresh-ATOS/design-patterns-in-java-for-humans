package com.pmareke;

import com.pmareke.models.Designer;
import com.pmareke.models.Developer;
import com.pmareke.models.Organization;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AppTest {
    @Test
    public void shouldAnswerWith27kSalary() {
        Developer john = new Developer("John Doe", 12000);
        Designer jane = new Designer("Jane Doe", 15000);

        Organization organization = new Organization();
        organization.addEmployee(john);
        organization.addEmployee(jane);

        assertTrue(organization.getNetSalaries() == 27000);
    }

    @Test
    public void shouldAnswerWith7kSalaray() {
        Developer john = new Developer("John Doe", 2000);
        Designer jane = new Designer("Jane Doe", 5000);

        Organization organization = new Organization();
        organization.addEmployee(john);
        organization.addEmployee(jane);

        assertTrue(organization.getNetSalaries() == 7000);
    }
}
