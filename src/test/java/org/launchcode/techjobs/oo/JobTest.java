package org.launchcode.techjobs.oo;

import org.junit.Test;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job job1 = new Job("Web Developer", new Employer("LaunchCode"), new Location("StL"), new PositionType("Back-end developer"), new CoreCompetency("Java"));
        Job job2 = new Job("Web Graphics", new Employer("CodeLaunch"), new Location("LtS"), new PositionType("Front-end developer"), new CoreCompetency("Java"));
        assertNotEquals(job1, job2);
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(job1.getName(), "Product tester");
        assertEquals(job1.getEmployer().toString(), "ACME");
        assertEquals(job1.getLocation().toString(), "Desert");
        assertEquals(job1.getPositionType().toString(), "Quality control");
        assertEquals(job1.getCoreCompetency().toString(), "Persistence");
    }
    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Web Graphics", new Employer("CodeLaunch"), new Location("StL"), new PositionType("Front-end developer"), new CoreCompetency("Java"));
        Job job2 = new Job("Web Graphics", new Employer("CodeLaunch"), new Location("StL"), new PositionType("Front-end developer"), new CoreCompetency("Java"));
        assertNotEquals(job1, job2);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job1 = new Job("TestName", new Employer("LaunchCode"), new Location("StL"), new PositionType("TestPostitionType"), new CoreCompetency("TestCompetency"));
        assertTrue(job1.toString().startsWith(lineSeparator()));
        assertTrue(job1.toString().endsWith(lineSeparator()));
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job1 = new Job("Web Developer", new Employer("LaunchCode"), new Location("StL"), new PositionType(""), new CoreCompetency("Java"));
        String expectedString = lineSeparator() +
                "ID: " + job1.getId() + "\n" +
                "Name: Web Developer" + "\n" +
                "Employer: LaunchCode" + "\n" +
                "Location: StL" + "\n" +
                "Position Type: Data not available" + "\n" +
                "Core Competency: Java" + lineSeparator();
        assertEquals(job1.toString(), expectedString);
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job1 = new Job("TestName", new Employer("LaunchCode"), new Location("StL"), new PositionType("TestPosition"), new CoreCompetency("TestCompetency"));
        String expectedString1 = lineSeparator() +
                "ID: " + job1.getId() + "\n" +
                "Name: TestName" + "\n" +
                "Employer: LaunchCode" + "\n" +
                "Location: StL" + "\n" +
                "Position Type: TestPosition" + "\n" +
                "Core Competency: TestCompetency" + lineSeparator();
        assertEquals(job1.toString(), expectedString1);
    }
}
