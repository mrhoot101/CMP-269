package Exercise_2;

public abstract class SmartDevice implements Powerable{
	static int activeDevicesCount = 0;
	protected String deviceName;
	protected boolean isOn;
	
	public SmartDevice(String deviceName) {
		this.deviceName = deviceName;
		this.isOn = false;
	}
	 @Override
	public void turnOn() {
		isOn = true;
	}
	 @Override
	public void turnOff() {
		isOn = false;
	}
	abstract void performSelfDiagnostic();
}