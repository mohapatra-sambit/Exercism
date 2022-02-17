import java.util.stream.IntStream;

class ReverseString {

//	String reverse(String inputString) {
//		char[] strArr = inputString.toCharArray();
//		int l = inputString.length();
//		int n = l / 2;
//		for (int i = 0; i < n; i++) {
//			char temp = strArr[i];
//			strArr[i] = strArr[--l];
//			strArr[l] = temp;
//		}
//		return new String(strArr);
//	}

	String reverse(String inputString) {
		return IntStream.range(0, inputString.length()).map(i -> inputString.charAt(inputString.length() - i - 1))
				.collect(StringBuilder::new, (sb, c) -> sb.append((char) c), StringBuilder::append).toString();
	}

}

