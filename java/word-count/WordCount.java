import java.util.HashMap;
import java.util.Map;

class WordCount {

	public Map<String, Integer> phrase(String phrase) {
		final Map<String, Integer> map = new HashMap<>();
		String[] allWords = phrase.toLowerCase().split("[!&@$%^:.,\\s\\n]");
		for (String word : allWords) {
			if (word.trim().length() > 0) {
				if (word.startsWith("'")) {
					word = word.substring(1);
				}
				if (word.endsWith("'")) {
					word = word.substring(0, word.length() - 1);
				}
				Integer curr = map.getOrDefault(word, 0);
				map.put(word, ++curr);
			}
		}
		return map;
	}

}
