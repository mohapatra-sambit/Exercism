import java.util.Random;

class DnDCharacter {

	private int strength, dexterity, constitution, intelligence, wisdom, charisma, hitpoints;

	public DnDCharacter() {
		strength = ability();
		dexterity = ability();
		constitution = ability();
		intelligence = ability();
		wisdom = ability();
		charisma = ability();
		hitpoints = 10 + modifier(constitution);
	}

	int ability() {
		return new Random().ints(4, 1, 7).sorted().skip(1).sum();
	}

	int modifier(int input) {
		double d = (input - 10) / 2d;
		return (int) Math.floor(d);
	}

	int getStrength() {
		return strength;
	}

	int getDexterity() {
		return dexterity;
	}

	int getConstitution() {
		return constitution;
	}

	int getIntelligence() {
		return intelligence;
	}

	int getWisdom() {
		return wisdom;
	}

	int getCharisma() {
		return charisma;
	}

	int getHitpoints() {
		return hitpoints;
	}

}

