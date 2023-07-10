import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class TwelveDays {

	private static final String START = "On the ${day} day of Christmas my true love gave to me: ";

	private static Map<Integer, Verse> verseMap = new HashMap<Integer, Verse>();

	static {
		verseMap.put(1, new Verse("first", "a Partridge in a Pear Tree."));
		verseMap.put(2, new Verse("second", "two Turtle Doves"));
		verseMap.put(3, new Verse("third", "three French Hens"));
		verseMap.put(4, new Verse("fourth", "four Calling Birds"));
		verseMap.put(5, new Verse("fifth", "five Gold Rings"));
		verseMap.put(6, new Verse("sixth", "six Geese-a-Laying"));
		verseMap.put(7, new Verse("seventh", "seven Swans-a-Swimming"));
		verseMap.put(8, new Verse("eighth", "eight Maids-a-Milking"));
		verseMap.put(9, new Verse("ninth", "nine Ladies Dancing"));
		verseMap.put(10, new Verse("tenth", "ten Lords-a-Leaping"));
		verseMap.put(11, new Verse("eleventh", "eleven Pipers Piping"));
		verseMap.put(12, new Verse("twelfth", "twelve Drummers Drumming"));
	}

	String verse(int verseNumber) {
		StringBuffer buf = new StringBuffer(setDay(START, verseMap.get(verseNumber).getDay()));
		switch (verseNumber) {
		case 12:
			buf.append(verseMap.get(12)).append(", ");
		case 11:
			buf.append(verseMap.get(11)).append(", ");
		case 10:
			buf.append(verseMap.get(10)).append(", ");
		case 9:
			buf.append(verseMap.get(9)).append(", ");
		case 8:
			buf.append(verseMap.get(8)).append(", ");
		case 7:
			buf.append(verseMap.get(7)).append(", ");
		case 6:
			buf.append(verseMap.get(6)).append(", ");
		case 5:
			buf.append(verseMap.get(5)).append(", ");
		case 4:
			buf.append(verseMap.get(4)).append(", ");
		case 3:
			buf.append(verseMap.get(3)).append(", ");
		case 2:
			buf.append(verseMap.get(2)).append(", ");
		case 1:
			if (verseNumber > 1) {
				buf.append("and ");
			}
			buf.append(verseMap.get(1)).append("\n");
		}
		return buf.toString();
	}

	private String setDay(String str, String day) {
		return str.replace("${day}", day);
	}

	String verses(int startVerse, int endVerse) {
		return IntStream.range(startVerse, endVerse + 1).collect(StringBuffer::new, (buf, i) -> {
			buf.append(verse(i));
			if (i < endVerse) {
				buf.append("\n");
			}
		}, StringBuffer::append).toString();
	}

	String sing() {
		return verses(1, 12);
	}

}

class Verse {

	private String day;

	private String verse;

	public Verse(String day, String verse) {
		this.day = day;
		this.verse = verse;
	}

	public String getDay() {
		return day;
	}

	@Override
	public String toString() {
		return verse;
	}

}

