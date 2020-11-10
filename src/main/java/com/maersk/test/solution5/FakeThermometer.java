package com.maersk.test.solution5;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FakeThermometer implements Thermometer{
	private int currentTemperature = 21;

	@Override
	public int measure() { return currentTemperature++; }
	
}
