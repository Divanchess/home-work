package com.sbrf.reboot.atm.sensors;

public abstract class Sensors {
    protected boolean isSuccess = false;
    public abstract boolean getStatus();
    public abstract void initialize();
    public abstract boolean verify();

    public static class DoorSensor extends Sensors {
        @Override
        public boolean getStatus(){
            return this.isSuccess;
        }

        public void initialize() {
            this.isSuccess = true;
        }

        public boolean verify() {
            boolean isDoorClosed = true;
            // Do job
            return isDoorClosed;
        }
    }

    public static class ShockSensor extends Sensors {
        @Override
        public boolean getStatus(){
            return this.isSuccess;
        }

        public void initialize() {
            this.isSuccess = true;
        }

        public boolean verify() {
            boolean isVibrationLevelSafe = true;
            // Do job
            return isVibrationLevelSafe;
        }
    }
}
