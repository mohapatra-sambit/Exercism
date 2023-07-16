import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

class SumOfMultiples {

	private int sum = 0;

	SumOfMultiples(int number, int[] set) {
		Set<Integer> t = new HashSet<Integer>();
		Arrays.stream(set).forEach(i -> {
			if (i > 0 && i < number) {
				IntStream.iterate(i, j -> j + i).limit((int) ((number - 1) / i)).forEach(m -> t.add(m));
			}
		});
		sum = t.stream().mapToInt(i -> i).sum();
	}

	int getSum() {
		return sum;
	}

}

