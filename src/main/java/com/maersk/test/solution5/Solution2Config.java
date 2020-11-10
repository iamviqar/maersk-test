package com.maersk.test.solution5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@Import({ FakeThermometer.class, WeatherForecastService.class })
public class Solution2Config {
		

		@Autowired
		WeatherForecastService weatherForecastService;

		@Bean
		public TemperatureMeasurementCallback callback() {
			return (temperature) -> System.out.println(temperature);
		}

		@Scheduled(fixedDelay = 50)
		public void scheduleFixedDelayTask() {
			weatherForecastService.takeTemperatureMeasurement();
		}

	
}
