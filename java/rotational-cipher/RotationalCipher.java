import java.util.stream.Collector;

class RotationalCipher {

	private int shiftKey;

	RotationalCipher(int shiftKey) {
		this.shiftKey = shiftKey;
	}

	String rotate(String data) {
		return data.chars().mapToObj((c) -> {
			if (Character.isAlphabetic(c)) {
				int start = Character.isUpperCase(c) ? 65 : 97;
				int end = Character.isUpperCase(c) ? 90 : 122;
				return (c + shiftKey) > end ? start + (c + shiftKey - end) - 1 : (c + shiftKey);
			} else {
				return c;
			}
		}).collect(Collector.of(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append,
				StringBuilder::toString));
	}

}

