package Exercise_2;


public class SmartLight extends SmartDevice implements Adjustable{
	private int brightness;

	public SmartLight(String deviceName) {
		super(deviceName);
		brightness = 0;
	}

	@Override
	public void turnOn() {
		isOn = true;
		if (isOn) {
			activeDevicesCount++;
		}
	}

	@Override
	public void turnOff() {
		isOn = false;
		if (!isOn) {
			activeDevicesCount--;
		}
	}

	@Override
	public void setLevel(int level) {
		if (isOn) {
			if (0 <= level && level <= 100) {
				brightness = level;
			}
		}
		else {
			System.err.println("Cannot adjust: Device is OFF.");
		}
	}

	@Override
	void performSelfDiagnostic() {
		System.out.println("Checking LED health...");
	}
	
}
