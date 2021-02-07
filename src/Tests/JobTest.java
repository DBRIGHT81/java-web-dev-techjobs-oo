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
}
