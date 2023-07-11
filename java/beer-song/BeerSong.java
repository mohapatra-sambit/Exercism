import java.util.Collections;
import java.util.stream.IntStream;

class BeerSong {

	private static String LINE = "${1} of beer on the wall, ${1} of beer.\n"
			+ "Take ${3} down and pass it around, ${2} of beer on the wall.\n\n";
	private static final String ZERO_LINE = "No more bottles of beer on the wall, no more bottles of beer.\n"
			+ "Go to the store and buy some more, 99 bottles of beer on the wall.\n\n";
	private int numOfBottles;

	public String sing(int numOfBottles, int numOfLines) {
		this.numOfBottles = numOfBottles;
		return IntStream.rangeClosed(1, numOfLines).boxed().sorted(Collections.reverseOrder())
				.collect(StringBuffer::new, (buf, i) -> buf.append(getLineFor(this.numOfBottles--)),
						StringBuffer::append)
				.toString();
	}

	public String singSong() {
		return sing(99, 100);
	}

	private String getLineFor(int numOfBottles) {
		String line = "";
		switch (numOfBottles) {
		case 0:
			return ZERO_LINE;
		case 1:
			line = replacePlaceHolders("1 bottle", "no more bottles", "it");
			break;
		case 2:
			line = replacePlaceHolders("2 bottles", "1 bottle", "one");
			break;
		default:
			line = replacePlaceHolders(numOfBottles + " bottles", (numOfBottles - 1) + " bottles", "one");
			break;
		}
		return line;
	}

	private String replacePlaceHolders(String one, String two, String three) {
		return LINE.replaceAll("\\$\\{1\\}", one).replaceAll("\\$\\{2\\}", two).replaceAll("\\$\\{3\\}", three);
	}

}
