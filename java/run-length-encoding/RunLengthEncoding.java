import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class RunLengthEncoding {

	public String encode(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}
		StringBuilder buf = new StringBuilder();
		for (int i = 0, j = i; i < str.length(); i = j) {
			int count = 0;
			char ch = str.charAt(i);
			while (j < str.length() && ch == str.charAt(j)) {
				count++;
				j++;
			}
			if (count > 1) {
				buf.append(count);
			}
			buf.append(ch);
		}
		return buf.toString();
	}

	public String decode(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}
		StringBuilder buf = new StringBuilder();
		String[] temp = str.split("[a-zA-Z\\s]");
		String[] chars = str.split("\\d+");
		chars = Arrays.copyOfRange(chars, 1, chars.length);
		if (temp.length == 0 || chars.length == 0) {
			return str;
		}
		List<String> counts = Arrays.asList(temp).stream().filter(c -> !c.equals("")).collect(Collectors.toList());
		for (int i = 0; i < counts.size(); i++) {
			Integer count = Integer.valueOf(counts.get(i));
			String charStr = chars[i];
			char ch = charStr.charAt(0);
			for (int j = 0; j < count; j++) {
				buf.append(ch);
			}
			if (charStr.length() > 1) {
				for (int j = 1; j < charStr.length(); j++) {
					buf.append(charStr.charAt(j));
				}
			}
		}
		return buf.toString();
	}

}
