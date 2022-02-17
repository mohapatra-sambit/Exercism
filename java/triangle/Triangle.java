class Triangle {

	private boolean isEquilateral;
	private boolean isIsoceles;

	Triangle(double side1, double side2, double side3) throws TriangleException {
		validate(side1, side2, side3);
		if (side1 == side2) {
			if (side2 == side3) {
				isEquilateral = true;
				isIsoceles = true;
			} else {
				isEquilateral = false;
				isIsoceles = true;
			}
		} else {
			if (side1 == side3 || side2 == side3) {
				isEquilateral = false;
				isIsoceles = true;
			}
		}
	}

	private void validate(double side1, double side2, double side3) throws TriangleException {
		if (side1 == 0 || side2 == 0 || side3 == 0) {
			throw new TriangleException();
		}
		if (((side1 + side2) < side3) || ((side2 + side3) < side1) || ((side3 + side1) < side2)) {
			throw new TriangleException();
		}
	}

	boolean isEquilateral() {
		return isEquilateral;
	}

	boolean isIsosceles() {
		return isIsoceles;
	}

	boolean isScalene() {
		return !isEquilateral && !isIsoceles;
	}

}

