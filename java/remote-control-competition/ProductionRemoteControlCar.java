class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {

    private Integer distance = 0;
	private Integer numOfVic = 0;

	public void drive() {
        distance += 10;
    }

    public int getDistanceTravelled() {
    	return distance;
    }

    public int getNumberOfVictories() {
        return numOfVic;
    }

    public void setNumberOfVictories(int numberofVictories) {
        numOfVic = numberofVictories;
    }

	@Override
	public int compareTo(ProductionRemoteControlCar o) {
		return this.numOfVic.compareTo(o.numOfVic);
	}
}
