import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Proverb {

	private static final String for_want = "For want of a ";
	private static final String the = " the ";
	private static final String lost = " was lost.\n";
	private static final String last = "And all for the want of a ";
	private static final String dot = ".";

	private String proverb = "";

	Proverb(String[] words) {
		if (words.length > 0) {
			proverb = IntStream.range(0, words.length - 1)
					.mapToObj(i -> for_want + words[i] + the + words[i + 1] + lost).collect(Collectors.joining())
					.concat(last + words[0] + dot);
		}
	}

	String recite() {
		return proverb;
	}

}

