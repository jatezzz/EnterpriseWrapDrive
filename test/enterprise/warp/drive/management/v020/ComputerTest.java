package enterprise.warp.drive.management.v020;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ComputerTest {

    public ComputerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void whenNoDamageAnd100PercentSpeedLigthThenReturnOperatingFlow() {
        System.out.println("getReportInjectors");
        Computer instance = new Computer();
        String expResult = "A: 100 mg/s, B: 100 mg/s, C: 100 mg/s";
        String expResultTime = "Infinite";
        instance.SetState(0, 0, 0, 100);
        String result = instance.getReportInjectors();
        String resultTime = instance.getTimeReportInjectors();
        assertEquals(expResult, result);
        assertEquals(expResultTime, resultTime);

    }

    @Test
    public void whenNoDamageAndNo100PercentSpeedLigthThenReturnOperatingFlowAndTime() {

        Computer instance = new Computer();
        String expResult = "A: 90 mg/s, B: 90 mg/s, C: 90 mg/s";
        String expResultTime = "Infinite";
        instance.SetState(0, 0, 0, 90);
        String result = instance.getReportInjectors();
        String resultTime = instance.getTimeReportInjectors();
        assertEquals(expResult, result);
        assertEquals(expResultTime, resultTime);

    }

    @Test
    public void whenNoDamageAndLowPercentSpeedLigthThenReturnOperatingFlowAndTime() {

        Computer instance = new Computer();
        String expResult = "A: 30 mg/s, B: 30 mg/s, C: 30 mg/s";
        String expResultTime = "Infinite";
        instance.SetState(0, 0, 0, 30);
        String result = instance.getReportInjectors();
        String resultTime = instance.getTimeReportInjectors();
        assertEquals(expResult, result);
        assertEquals(expResultTime, resultTime);

    }

    @Test
    public void whenDamageTwoInjectorsAnd100PercentSpeedLigthThenReturnOperatingFlowAndTime() {

        Computer instance = new Computer();
        String expResult = "A: 90 mg/s, B: 100 mg/s, C: 110 mg/s";
        String expResultTime = "90 min";
        instance.SetState(20, 10, 0, 100);
        String result = instance.getReportInjectors();
        String resultTime = instance.getTimeReportInjectors();
        assertEquals(expResult, result);
        assertEquals(expResultTime, resultTime);

    }

    @Test
    public void whenOne100PercentDamageInjectorAndNo100PercentSpeedLigthThenReturnOperatingFlowAndTime() {

        Computer instance = new Computer();
        String expResult = "A: 120 mg/s, B: 120 mg/s, C: 0 mg/s";
        String expResultTime = "80 min";
        instance.SetState(0, 0, 100, 80);
        String result = instance.getReportInjectors();
        String resultTime = instance.getTimeReportInjectors();
        System.out.println("result" + result);
        System.out.println("resultTime" + resultTime);
        assertEquals(expResult, result);
        assertEquals(expResultTime, resultTime);

    }

    @Test
    public void whenNoDamageAndOver100PercentSpeedLigthThenReturnOperatingFlowAndTime() {

        Computer instance = new Computer();
        String expResult = "A: 150 mg/s, B: 150 mg/s, C: 150 mg/s";
        String expResultTime = "50 min";
        instance.SetState(0, 0, 0, 150);
        String result = instance.getReportInjectors();
        String resultTime = instance.getTimeReportInjectors();
        assertEquals(expResult, result);
        assertEquals(expResultTime, resultTime);

    }

    @Test
    public void whenOneDamageInjectorAndOver100PercentSpeedLigthThenReturnOperatingFlowAndTime() {

        Computer instance = new Computer();
        String expResult = "A: 150 mg/s, B: 150 mg/s, C: 120 mg/s";
        String expResultTime = "50 min";
        instance.SetState(0, 0, 30, 140);
        String result = instance.getReportInjectors();
        String resultTime = instance.getTimeReportInjectors();
        assertEquals(expResult, result);
        assertEquals(expResultTime, resultTime);

    }

    @Test
    public void whenExesiveDamageAndOver100PercentSpeedLigthThenUnabilityAndTime() {

        Computer instance = new Computer();
        String expResult = "Unable to comply";
        String expResultTime = "0 min";
        instance.SetState(20, 50, 40, 170);
        String result = instance.getReportInjectors();
        String resultTime = instance.getTimeReportInjectors();
        System.out.println("result" + result);
        System.out.println("resultTime" + resultTime);
        assertEquals(expResult, result);
        assertEquals(expResultTime, resultTime);

    }

}
