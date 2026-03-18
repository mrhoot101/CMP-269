package Exercise_2;

public class SmartThermostat extends SmartDevice implements Adjustable{
	private int temperature;

	public SmartThermostat(String deviceName) {
		super(deviceName);
		temperature = 60;
	}

	@Override
	public void turnOn() {
		System.out.println("HVAC System Starting...");
		super.turnOn();
		activeDevicesCount++;
	}

	@Override
	public void turnOff() {
		super.turnOn();
		activeDevicesCount--;
	}

	@Override
	public void setLevel(int level) {
		if (60 <= level && level <= 80) {
			temperature = level;
		}
	}

	@Override
	void performSelfDiagnostic() {
		System.out.println("Checking Heating System...");
		
	}

}
