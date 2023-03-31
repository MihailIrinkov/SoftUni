package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class AlarmTest {

    @Test
    public void testIfPressureIsNormal() {
        Sensor mockSensor = Mockito.mock(Sensor.class);
        Mockito.when(mockSensor.popNextPressurePsiValue()).thenReturn(19.2);

        Alarm alarm = new Alarm(mockSensor);
        alarm.check();

        Assert.assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void testWhenPressureIsTooHigh() {
        Sensor mockSensor = Mockito.mock(Sensor.class);
        Mockito.when(mockSensor.popNextPressurePsiValue()).thenReturn(25.5);

        Alarm alarm = new Alarm(mockSensor);
        alarm.check();

        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testWhenPressureIsLow() {
        Sensor mockSensor = Mockito.mock(Sensor.class);
        Mockito.when(mockSensor.popNextPressurePsiValue()).thenReturn(16.5);

        Alarm alarm = new Alarm(mockSensor);
        alarm.check();

        Assert.assertTrue(alarm.getAlarmOn());
    }

}