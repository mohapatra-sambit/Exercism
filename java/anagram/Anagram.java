import java.util.List;
import java.util.stream.Collectors;

class Anagram {

	private String originalWord, sortedWord;

	public Anagram(String word) {
		this.originalWord = word.toLowerCase();
		this.sortedWord = sort(word);
	}

	private String sort(String str) {
		return str.toLowerCase().chars().sorted()
				.collect(StringBuilder::new,
						StringBuilder::appendCodePoint,
						StringBuilder::append).toString();
	}

	public List<String> match(List<String> listOfWords) {
		return listOfWords.stream().filter(s -> {
			return !(originalWord.equals(s.toLowerCase())) && sortedWord.equals(sort(s));
		}).collect(Collectors.toList());
	}
}
