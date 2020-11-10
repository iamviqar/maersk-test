package com.maersk.test.solution1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.jupiter.api.Test;

public class Solution1Tests {

	@Test
	void itShouldRaiseAlerts() {
		AlertService alertService = new AlertService(new MapAlertDAO());
		UUID uuid1 =alertService.raiseAlert();
		assertThat(alertService.getAlertTime(uuid1)).isNotNull();
	}

}
