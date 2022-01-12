package com.sbrf.reboot.atm.sensors;

public abstract class Sensor {
    protected boolean isSuccess = false;
    public abstract boolean getStatus();
    public abstract void initialize();
    public abstract boolean verify();

    public static class DoorSensor extends Sensor {
        @Override
        public boolean getStatus(){
            return this.isSuccess;
        }

        @Override
        public String toString() {
            return "DoorSensor";
        }

        public void initialize() {
            this.isSuccess = true;
            System.out.println("Initialization is successful");
        }

        public boolean verify() {
            boolean isDoorClosed = true;
            // Do job
            return isDoorClosed;
        }
    }

    public static class ShockSensor extends Sensor {
        @Override
        public boolean getStatus(){
            return this.isSuccess;
        }

        @Override
        public String toString() {
            return "ShockSensor";
        }

        public void initialize() {
            this.isSuccess = true;
            System.out.println("Initialization is successful");
        }

        public boolean verify() {
            boolean isVibrationLevelSafe = true;
            // Do job
            return isVibrationLevelSafe;
        }
    }
}
