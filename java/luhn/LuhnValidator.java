class LuhnValidator {

	boolean isValid(String candidate) {
		candidate = candidate.trim();
		if (candidate.length() < 2 || candidate.contains("-") || candidate.contains("#") || candidate.contains("$")
				|| candidate.contains(":") || candidate.contains("&")) {
			return false;
		}
		candidate = candidate.replaceAll("\\s", "");
		int sum = 0;
		for (int i = candidate.length() - 2; i >= 0; i -= 2) {
			sum += Character.getNumericValue(candidate.charAt(i + 1));
			int x = Character.getNumericValue(candidate.charAt(i));
			x += x;
			sum += x > 9 ? x - 9 : x;
		}

		return (sum % 10 == 0);
	}

}

