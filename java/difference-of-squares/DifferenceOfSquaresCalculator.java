import java.util.stream.IntStream;

class DifferenceOfSquaresCalculator {

	int computeSquareOfSumTo(int input) {
		int sum = IntStream.range(1, input + 1).sum();;
		return sum * sum;
	}

	int computeSumOfSquaresTo(int input) {
		int sum = IntStream.range(1, input + 1).map(i -> i*i).sum();
		return sum;
	}

	int computeDifferenceOfSquares(int input) {
		return Math.abs(computeSumOfSquaresTo(input) - computeSquareOfSumTo(input));
	}
	
}

