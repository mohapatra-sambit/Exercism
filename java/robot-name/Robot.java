import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Robot {

	private String name;
	private static List<String> oldNames;

	static {
		oldNames = new ArrayList<>();
	}

	public Robot() {
		reset();
	}

	public String getName() {
		return name;
	}

	public void reset() {
		Random random = new Random();
		String initials = generateInitials(random);
		Integer identifier = generateIdentifier(random);
		name = initials + identifier;
		if (oldNames.contains(name)) {
			reset();
		}
		oldNames.add(name);
	}

	private Integer generateIdentifier(Random random) {
		return generateRandomNumber(random, 100, 1000);
	}

	private String generateInitials(Random random) {
		char first = (char) generateRandomNumber(random, 65, 91);
		char second = (char) generateRandomNumber(random, 65, 91);
		StringBuffer buffer = new StringBuffer();
		buffer.append(first).append(second);
		return buffer.toString();
	}

	private int generateRandomNumber(Random random, int min, int max) {
		return random.ints(min, max).findFirst().getAsInt();
	}
}
