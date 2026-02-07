package Exercise_2;

import java.util.ArrayList;
import java.util.Iterator;

public class ChallengeLogic {

	public static void main(String[] args) {
		ArrayList<SmartDevice> homeHub = new ArrayList<SmartDevice>();
		SmartLight lightLivingRoom = new SmartLight("Living Room Light");
		SmartLight lightKitchen = new SmartLight("Kitchen Light");
		SmartDevice tempHallway = new SmartThermostat("Hallway Thermostat");
		
		homeHub.add(lightLivingRoom);
		homeHub.add(lightKitchen);
		homeHub.add(tempHallway);
		
		lightLivingRoom.turnOn();
		tempHallway.turnOn();
		
		lightKitchen.setLevel(75);
		
		System.out.println("Total active devices: " + SmartDevice.activeDevicesCount);
		
		for (Iterator iterator = homeHub.iterator(); iterator.hasNext();) {
			SmartDevice smartDevice = (SmartDevice) iterator.next();
			
		 smartDevice.performSelfDiagnostic();
		}
	}

}
