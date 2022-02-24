class AnnalynsInfiltration {
	public static boolean canFastAttack(boolean knightIsAwake) {
		return !knightIsAwake;
	}

	public static boolean canSpy(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake) {
		return knightIsAwake || archerIsAwake || prisonerIsAwake;
	}

	public static boolean canSignalPrisoner(boolean archerIsAwake, boolean prisonerIsAwake) {
		return prisonerIsAwake && !archerIsAwake;
	}

	public static boolean canFreePrisoner(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake,
			boolean petDogIsPresent) {
		if (prisonerIsAwake) {
			if (!knightIsAwake && !archerIsAwake) {
				return true;
			} else if (knightIsAwake && !archerIsAwake && petDogIsPresent) {
				return true;
			}
		} else {
			if (!archerIsAwake && petDogIsPresent) {
				return true;
			}
		}
		return false;
	}
}
