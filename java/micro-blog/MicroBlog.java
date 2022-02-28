class MicroBlog {

	public String truncate(String input) {
		return (input.length() > 5 ? new String(input.codePoints().limit(5).toArray(), 0, 5) : input);
	}

}

