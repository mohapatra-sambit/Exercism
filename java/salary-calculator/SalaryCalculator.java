public class SalaryCalculator {

	public double multiplierPerDaysSkipped(int daysSkipped) {
		return daysSkipped <= 4 ? 1.0 : 0.85;
	}

	public int multiplierPerProductsSold(int productsSold) {
		return productsSold > 20 ? 13 : 10;
	}

	public double bonusForProductSold(int productsSold) {
		return productsSold * multiplierPerProductsSold(productsSold);
	}

	public double finalSalary(int daysSkipped, int productsSold) {
		double salary = ifSkippedAboveAndSoldBelowThreshold(daysSkipped, productsSold) ? 1000
				: 1000 * multiplierPerDaysSkipped(daysSkipped);
		double bonus = ifSkippedAboveAndSoldBelowThreshold(daysSkipped, productsSold) ? 10 * productsSold
				: bonusForProductSold(productsSold);
		double finalSalary = salary + bonus;
		return finalSalary > 2000 ? 2000 : finalSalary;
	}

	public boolean ifSkippedAboveAndSoldBelowThreshold(int daysSkipped, int productsSold) {
		return daysSkipped > 4 && productsSold > 20;
	}

}

