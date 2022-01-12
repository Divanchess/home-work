package com.sbrf.reboot.atm.sensors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ValidatorTest {

    @Test
    void validateTest() {
        Sensor.DoorSensor doorSensor = new Sensor.DoorSensor();
        Sensor.ShockSensor shockSensor = new Sensor.ShockSensor();

        Validator<Sensor> validator = new Validator<>(new ArrayList<Sensor>() {{
            add(doorSensor);
            add(shockSensor);
        }});

        for (Sensor s : validator.getValidateList()) {
            System.out.println(s +" is active:" + s.getStatus());
            s.initialize();
            System.out.println(s +" is active:" + s.getStatus());
        }

        Assertions.assertTrue(validator.validate());
    }
}
