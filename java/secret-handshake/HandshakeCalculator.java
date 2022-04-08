import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class HandshakeCalculator {

	List<Signal> calculateHandshake(int number) {
		int reverseCount = number / 16;
		reverseCount = reverseCount < 1 ? 1 : reverseCount - 1;
		List<Signal> l = new ArrayList<>();
		String binary = Integer.toBinaryString(number);
		if (binary.length() >= 5) {
			int diff = binary.length() - 4;
			binary = binary.substring(diff);
		}
		int n = Integer.valueOf(binary);
		int i = Integer.toString(n).length();
		int t = n;
		while (t > 0) {
			int x = (int) Math.pow(10, i - 1);
			t = t % x;
			--i;
			addSignalToList(l, x);
		}
		for (int c = 1; c <= reverseCount; c++) {
			Collections.reverse(l);
		}
		return l;
	}

	private void addSignalToList(List<Signal> l, int x) {
		switch (x) {
		case 1:
			l.add(Signal.WINK);
			break;
		case 10:
			l.add(Signal.DOUBLE_BLINK);
			break;
		case 100:
			l.add(Signal.CLOSE_YOUR_EYES);
			break;
		case 1000:
			l.add(Signal.JUMP);
			break;
		}
	}

}

