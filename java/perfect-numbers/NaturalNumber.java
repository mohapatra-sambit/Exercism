import java.util.stream.IntStream;

class NaturalNumber {

	private Classification classification;

	public NaturalNumber(int number) {
		validate(number);
		int sumOfFactors = IntStream.range(1, (number / 2) + 1).filter(i -> {
			return (number % i == 0);
		}).sum();
		this.classification = sumOfFactors == number ? Classification.PERFECT
				: sumOfFactors > number ? Classification.ABUNDANT : Classification.DEFICIENT;
	}

	private void validate(int number) {
		if (number <= 0)
			throw new IllegalArgumentException("You must supply a natural number (positive integer)");
	}

	public Classification getClassification() {
		return classification;
	}

}

