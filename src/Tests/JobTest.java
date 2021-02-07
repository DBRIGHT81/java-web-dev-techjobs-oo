package Tests;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;


public class JobTest {
    private Job job1;
    private Job job2;
    @Before
    public void before(){
        job1 = new Job();
        job2 = new Job();
    }
    @Test
    public void  testSettingJobId(){
        assertNotEquals(job1.getId(), job2.getId());
        assertEquals(job1.getId(), job2.getId() - 1);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Employer employer = new Employer("Ridgewood");
        Location iceland = new Location("Iceland");
        PositionType management = new PositionType("Management");
        CoreCompetency persistent = new CoreCompetency("Persistent");
        String seniorAdvisor = "Senior Advisor";
        Job job = new Job(seniorAdvisor, employer, iceland, management, persistent);
        assertEquals(seniorAdvisor, job.getName());
        assertEquals(employer, job.getEmployer());
        assertEquals(iceland, job.getLocation());
        assertEquals(management, job.getPositionType());
        assertEquals(persistent, job.getCoreCompetency());
        assertTrue(job.getName() instanceof String);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality (){
        assertNotEquals(job1, job2);
    }

    @Test
    public void testForToString() {
        String jobAsString = job1.toString();
        assertTrue(jobAsString.startsWith("\n"));
        assertTrue(jobAsString.endsWith("\n"));
    }

    @Test
    public void testForLabel() {
        String expectedJobString = "\n" +
                "ID: " + job1.getId() +"\n" +
                "Name: Astronaut\n" +
                "Employer: NASA\n" +
                "Location: Florida\n" +
                "Position Type: Lead\n" +
                "Core Competency: Timeliness\n" ;

        job1.setName("Astronaut");
        job1.setEmployer(new Employer("NASA"));
        job1.setLocation(new Location("Florida"));
        job1.setPositionType(new PositionType("Lead"));
        job1.setCoreCompetency(new CoreCompetency("Timeliness"));
        assertEquals(expectedJobString, job1.toString());
    }

    @Test
    public void  testForEmptyFields() {
       String newExpectedJobString = "\n" +
                "ID: " + job1.getId() + "\n" +
                "Name: Front Office\n" +
                "Employer: Data not available\n" +
                "Location: Data not available\n" +
                "Position Type: Data not available\n" +
                "Core Competency: Data not available\n" ;


        job1.setName("Front Office");
        assertEquals(newExpectedJobString, job1.toString());

    }

    @Test
    public void testForAllEmptyFields(){
        assertEquals("\nOOPS! This job does not seem to exist.\n", job1.toString());
    }
}
