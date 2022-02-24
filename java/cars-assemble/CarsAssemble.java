public class CarsAssemble {

    public double productionRatePerHour(int speed) {
    	int total = speed * 221;
    	if (speed >= 1 && speed <= 4) {
    		return total;
    	} else if (speed >= 5 && speed <= 8) {
    		return (total * 0.9);
    	} else if (speed == 9) {
    		return (total * 0.8);
    	} else if (speed == 10) {
    		return (total * 0.77);
    	} else {
    		return 0;
    	}
    }

    public int workingItemsPerMinute(int speed) {
        return (int) (productionRatePerHour(speed)/60);
    }
}
