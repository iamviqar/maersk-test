package com.maersk.test.solution5;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service

public class WeatherForecastService {
	//@Autowired
	//private Thermometer thermometer;
	
	@Autowired
	private TemperatureMeasurementCallback callback;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	public void takeTemperatureMeasurement() {
		
	int temperature = getThermometer().measure();
	callback.temperatureMeasured(temperature);
	
	}
	
	private Thermometer getThermometer(){
		return applicationContext.getBean(Thermometer.class);
	}

}
