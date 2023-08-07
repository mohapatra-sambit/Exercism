import java.util.ArrayList;
import java.util.List;

class FoodChain {

	private static String I_KNOW = "I know an old lady who swallowed a ";
	private static String SHE = "She swallowed the ";
	private static String TO = " to catch the ";
	private static String I_DONT_KNOW = "I don't know why she swallowed the fly. Perhaps she'll die.";

	private List<Animal> animals = new ArrayList<Animal>();

	{
		animals.add(new Animal("fly", null, null));
		animals.add(new Animal("spider", "It wriggled and jiggled and tickled inside her.", null));
		animals.add(new Animal("bird", "How absurd to swallow a bird!",
				" that wriggled and jiggled and tickled inside her"));
		animals.add(new Animal("cat", "Imagine that, to swallow a cat!", null));
		animals.add(new Animal("dog", "What a hog, to swallow a dog!", null));
		animals.add(new Animal("goat", "Just opened her throat and swallowed a goat!", null));
		animals.add(new Animal("cow", "I don't know how she swallowed a cow!", null));
		animals.add(new Animal("horse", "She's dead, of course!", null));
	}

	public String verse(int verse) {
		--verse;
		StringBuilder buf = new StringBuilder();
		buf.append(I_KNOW);
		FoodChain.Animal animal = animals.get(verse);
		buf.append(animal.name).append(".");
		if (animal.line1 != null) {
			buf.append("\n").append(animal.line1);
		}
		switch (verse) {
		case 7:
			break;
		case 6:
			--verse;
			animal = addVerse(verse, animal, buf);
		case 5:
			--verse;
			animal = addVerse(verse, animal, buf);
		case 4:
			--verse;
			animal = addVerse(verse, animal, buf);
		case 3:
			--verse;
			animal = addVerse(verse, animal, buf);
		case 2:
			--verse;
			animal = addVerse(verse, animal, buf);
		case 1:
			--verse;
			animal = addVerse(verse, animal, buf);
		case 0: {
			buf.append("\n").append(I_DONT_KNOW);
		}
		}
		return buf.toString();
	}

	private FoodChain.Animal addVerse(int verse, FoodChain.Animal animal, StringBuilder buf) {
		FoodChain.Animal prev = animals.get(verse);
		buf.append("\n").append(SHE).append(animal.name).append(TO).append(prev.name);
		if (animal.line2 != null) {
			buf.append(animal.line2);
		}
		buf.append(".");
		return animals.get(verse);
	}

	public String verses(int startVerse, int endVerse) {
		StringBuilder buf = new StringBuilder();
		for (int i = startVerse; i <= endVerse; i++) {
			buf.append(verse(i));
			if (i < endVerse) {
				buf.append("\n\n");
			}
		}
		return buf.toString();
	}

	class Animal {

		private String name;

		private String line1;

		private String line2;

		public Animal(String name, String line1, String line2) {
			super();
			this.name = name;
			this.line1 = line1;
			this.line2 = line2;
		}

		@Override
		public String toString() {
			return name;
		}

	}

}
