import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class BaseConverter {

	private int sourceBase;
	private int[] digits;
	
	private int length;

	public BaseConverter(int base, int[] digits) {
		validate(base, digits);
		this.sourceBase = base;
		this.digits = digits;
		this.length = digits.length - 1;
	}

	private void validate(int base, int[] digits) {
		if (base < 2) {
			throw new IllegalArgumentException("Bases must be at least 2.");
		}
		for (int i : digits) {
			if (i < 0) {
				throw new IllegalArgumentException("Digits may not be negative.");
			}
			if (i >= base) {
				throw new IllegalArgumentException("All digits must be strictly less than the base.");
			}
		}
	}

	public int[] convertToBase(int targetBase) {
		if (targetBase < 2) {
			throw new IllegalArgumentException("Bases must be at least 2.");
		}
		return covertToTarget(convertToDecimal(), targetBase);
	}

	private int[] covertToTarget(int number, int targetBase) {
		List<Integer> l = new ArrayList<Integer>();
		while (number > 0) {
			int rem = number % targetBase;
			number = number / targetBase;
			l.add(rem);
		}
		Collections.reverse(l);
		int[] arr = new int[l.size() == 0 ? 1 : l.size()];
		int i = 0;
		for (Integer n : l) {
			arr[i++] = n;
		}
		return arr;
	}

	private int convertToDecimal() {
		return Arrays.stream(digits).map(i -> (int)(i * Math.pow(sourceBase, length--))).sum();
	}
	
}
