import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PhoneNumber {

	private String phoneNumber;

	public PhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		validateCharacters();
		this.phoneNumber = phoneNumber.replaceAll("[^\\d]", "");
		validateForLength();
		if (this.phoneNumber.length() == 11) {
			this.phoneNumber = this.phoneNumber.substring(1);
		}
		validateAreaCodeFor("0", "zero");
		validateAreaCodeFor("1", "one");
		validateExchangeCodeFor('0', "zero");
		validateExchangeCodeFor('1', "one");
	}

	private void validateCharacters() {
		validatePattern("[a-zA-Z]", "letters not permitted");
		validatePattern("[@:!]", "punctuations not permitted");
	}

	private void validatePattern(String patternString, String msg) {
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(this.phoneNumber);
		if (matcher.find()) {
			throwException(msg);
		}
	}

	private void validateForLength() {
		if (this.phoneNumber.length() < 10) {
			throwException("incorrect number of digits");
		} else if (this.phoneNumber.length() > 11) {
			throwException("more than 11 digits");
		} else if (this.phoneNumber.length() == 11 && !this.phoneNumber.startsWith("1")) {
			throwException("11 digits must start with 1");
		}
	}

	private void validateAreaCodeFor(String c, String s) {
		if (this.phoneNumber.startsWith(c)) {
			throwException("area code cannot start with " + s);
		}
	}

	private void validateExchangeCodeFor(char c, String s) {
		if (this.phoneNumber.charAt(3) == c) {
			throwException("exchange code cannot start with " + s);
		}
	}
	
	private void throwException(String msg) {
		throw new IllegalArgumentException(msg);
	}

	public String getNumber() {
		return phoneNumber;
	}
	
}
