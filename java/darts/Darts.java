class Darts {

	private int score;

	Darts(double x, double y) {
		double distance = calculateDistance(x, y);
		determineScore(distance);
	}

	private void determineScore(double distance) {
		score = distance <= 1 ? 10 : distance <= 5 ? 5 : distance <= 10 ? 1 : 0;
	}

	private double calculateDistance(double x, double y) {
		return Math.sqrt((x * x) + (y * y));
	}

	int score() {
		return score;
	}

}

