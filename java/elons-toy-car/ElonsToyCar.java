public class ElonsToyCar {

	private int distance = 0;

	private int battery = 100;

	public static ElonsToyCar buy() {
		return new ElonsToyCar();
	}

	public String distanceDisplay() {
		return "Driven " + distance + " meters";
	}

	public String batteryDisplay() {
		return battery == 0 ? "Battery empty" : "Battery at " + battery + "%";
	}

	public void drive() {
		distance = distance >= 2000 ? distance : distance + 20;
		battery = battery <= 0 ? 0 : battery - 1;
	}
}
