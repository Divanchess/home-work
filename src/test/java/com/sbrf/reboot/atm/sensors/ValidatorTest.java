package com.sbrf.reboot.atm.sensors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ValidatorTest {

    @Test
    void validateTest() {
        Sensors.DoorSensor doorSensor = new Sensors.DoorSensor();
        Sensors.ShockSensor shockSensor = new Sensors.ShockSensor();

        Validator<Sensors> validator = new Validator<>(new ArrayList<Sensors>() {{
            add(doorSensor);
            add(shockSensor);
        }});

        Assertions.assertTrue(validator.validate());
    }
}
