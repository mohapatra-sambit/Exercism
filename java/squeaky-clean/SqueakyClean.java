class SqueakyClean {
	static String clean(String identifier) {
		StringBuffer buffer = new StringBuffer();
		boolean capitalize = false;
		for (int i = 0; i < identifier.length(); i++) {
			Character ch = identifier.charAt(i);
			if (ch == '-') {
				capitalize = true;
				continue;
			}
			if (Character.isWhitespace(ch)) {
				buffer.append("_");
			} else if (Character.isISOControl(ch)) {
				buffer.append("CTRL");
			} else if (Character.isSurrogate(ch) || Character.isDigit(ch)) {
				buffer.append("");
			} else {
				int intVal = (int) ch;
				if (intVal >= 945 && intVal <= 970) {
					continue;
				} else {
					if (capitalize) {
						ch = Character.toUpperCase(ch);
						capitalize = false;
					}
					buffer.append(ch);
				}
			}
		}
		return buffer.toString();
	}
	
}
