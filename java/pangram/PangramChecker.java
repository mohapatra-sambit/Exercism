import java.util.stream.IntStream;

public class PangramChecker {

	public boolean isPangram(String input) {
		return IntStream.range(65, 91).filter(ch -> {
			return input.toUpperCase().contains("" + (char) ch);
		}).count() == 26;
	}

}

