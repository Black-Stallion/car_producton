package org.hqu.production_ms.domain.po;

import org.hqu.production_ms.domain.DeviceFault;

public class DeviceFaultPO extends DeviceFault{
	
	private String deviceName;
	
	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
}