class ArmstrongNumbers {

	boolean isArmstrongNumber(int numberToCheck) {
		String num = String.valueOf(numberToCheck);
		int number = numberToCheck;
		int len = num.length();
		int sum = 0;
		while (numberToCheck > 0) {
			int digit = numberToCheck % 10;
			sum += Math.pow(digit, len);
			numberToCheck = numberToCheck / 10;
		}
		return sum == number;
	}

}

