package com.maersk.test.solution5;

@FunctionalInterface
public interface TemperatureMeasurementCallback {
	public void temperatureMeasured(int temperature);
}
