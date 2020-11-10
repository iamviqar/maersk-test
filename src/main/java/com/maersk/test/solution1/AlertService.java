package com.maersk.test.solution1;

import java.util.Date;
import java.util.UUID;

class AlertService {
	private AlertDAO storage;

	AlertService(AlertDAO alertDAO) {
		this.storage = alertDAO;
	}

	public UUID raiseAlert() {
		return this.storage.addAlert(new Date());
	}

	public Date getAlertTime(UUID id) {
		return this.storage.getAlert(id);
	}
}
