import java.util.Arrays;

class Acronym {

	private String acronym;

	Acronym(String phrase) {
		acronym = Arrays.stream(phrase.split("[-_\\s]")).map(s -> {
			if (s.trim().length() == 0)
				return "";
			return Character.toUpperCase(s.charAt(0));
		}).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
	}

	String get() {
		return acronym;
	}

}

