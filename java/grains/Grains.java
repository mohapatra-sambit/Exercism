import java.math.BigInteger;
import java.util.stream.IntStream;

class Grains {

	private BigInteger total;

	public Grains() {
		total = new BigInteger("0");
		IntStream.range(0, 64).forEach(sqr -> {
			total = total.add(BigInteger.TWO.pow(sqr));
		});
	}

	BigInteger grainsOnSquare(final int square) {
		validate(square);
		return BigInteger.TWO.pow(square - 1);
	}

	private void validate(int square) {
		if (square < 1 || square > 64) {
			throw new IllegalArgumentException("square must be between 1 and 64");
		}
	}

	BigInteger grainsOnBoard() {
		return total;
	}

}

