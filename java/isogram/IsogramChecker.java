import java.util.ArrayList;
import java.util.List;

class IsogramChecker {

	boolean isIsogram(String phrase) {
		if (phrase.trim().length() == 0)
			return true;
		final List<Character> list = new ArrayList<>();
		boolean chk = phrase.chars().allMatch(i -> {
			char ch = Character.toLowerCase((char) i);
			if (list.contains(ch)) {
				return false;
			}
			if (ch != ' ' && ch != '-') {
				list.add(ch);
			}
			return true;
		});
		return chk;
	}

}

