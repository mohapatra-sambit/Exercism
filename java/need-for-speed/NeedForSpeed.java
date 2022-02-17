class NeedForSpeed {
	
    public int batteryDrain = 5;
    
	public int speed = 2;

	private int distanceDriven = 0;
	
	private int batteryLeft = 100;

	public NeedForSpeed(int speed, int batteryDrain) {
		this.speed = speed;
		this.batteryDrain = batteryDrain;
	}

    public boolean batteryDrained() {
    	return batteryLeft <= 0;
    }

    public int distanceDriven() {
    	return distanceDriven;
    }

    public void drive() {
    	if (!batteryDrained()) {
    		distanceDriven += speed;
    		batteryLeft -= batteryDrain;
    	}
    }

    public static NeedForSpeed nitro() {
    	return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {
	
    private int distance = 800;

	public RaceTrack(int distance) {
		this.distance = distance;
	}

    public boolean carCanFinish(NeedForSpeed car) {
    	while (!car.batteryDrained()) {
    		car.drive();
    		if (car.distanceDriven() >= distance) {
    			return true;
    		}
    	}
    	return false;
    }
}

