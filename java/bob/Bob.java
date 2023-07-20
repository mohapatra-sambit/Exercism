class Bob {

	public String hey(String msg) {
		msg = msg.trim();
		if (!msg.chars()
				.allMatch(ch -> Character.isDigit((char) (ch)) || isSpecial((char) ch) || Character.isWhitespace(ch))) {
			if (msg.chars().allMatch(ch -> (ch < 97 || ch > 122))) {
				if (msg.endsWith("?")) {
					return "Calm down, I know what I'm doing!";
				}
				return "Whoa, chill out!";
			}
		} else if (msg.chars().allMatch(ch -> Character.isWhitespace(ch))) {
			return "Fine. Be that way!";
		}
		if (msg.endsWith("?")) {
			return "Sure.";
		}
		return "Whatever.";
	}

	private boolean isSpecial(char ch) {
		return !Character.isDigit(ch) && !Character.isLetter(ch) && !Character.isWhitespace(ch);
	}

}
