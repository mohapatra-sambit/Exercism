import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

class LargestSeriesProductCalculator {

	private String number;

	LargestSeriesProductCalculator(String inputNumber) {
		validate(inputNumber);
		this.number = inputNumber;
	}

	long calculateLargestProductForSeriesLength(int numberOfDigits) {
		if (numberOfDigits > number.length()) {
			throw new IllegalArgumentException(
					"Series length must be less than or equal to the length of the string to search.");
		}
		if (numberOfDigits < 0) {
			throw new IllegalArgumentException("Series length must be non-negative.");
		}
		return IntStream.rangeClosed(0, number.length() - numberOfDigits)
				.mapToObj(i -> number.substring(i, (i + numberOfDigits))).sequential().map(s -> {
					long n = s.chars().mapToLong(Character::getNumericValue).reduce(1, (p, i) -> p * i);
					return n;
				}).max(Comparator.comparing(Long::valueOf)).get();
	}

	private void validate(String number) {
		Matcher matcher = Pattern.compile("\\D").matcher(number);
		if (matcher.find()) {
			throw new IllegalArgumentException("String to search may only contain digits.");
		}
	}

}

