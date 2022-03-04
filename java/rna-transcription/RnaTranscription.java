import java.util.HashMap;
import java.util.Map;

class RnaTranscription {

	private static final Map<Character, Character> map = new HashMap<>();

	static {
		map.put('G', 'C');
		map.put('C', 'G');
		map.put('T', 'A');
		map.put('A', 'U');
	}

	String transcribe(String dnaStrand) {
		return dnaStrand.chars().map(ch -> {
			return map.get((char) ch);
		}).collect(StringBuilder::new, (x, y) -> x.append((char) y), StringBuilder::append).toString();
	}

}

