class RaindropConverter {

	private boolean flag = false;

	String convert(int number) {
		StringBuffer str = new StringBuffer();
		checkFor(3, number, str, "Pling");
		checkFor(5, number, str, "Plang");
		checkFor(7, number, str, "Plong");
		return flag ? str.toString() : String.valueOf(number);
	}

	private void checkFor(int n, int number, StringBuffer str, String txt) {
		if (number % n == 0) {
			str.append(txt);
			flag = true;
		}
	}

}

