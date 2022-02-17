public class Hamming {
	
	private int hammingDistance;

	public Hamming(String leftStrand, String rightStrand) {
		validate(leftStrand, rightStrand);
		for (int i=0; i<leftStrand.length(); i++) {
			if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
				hammingDistance++;
			}
		}
		
    }

    private void validate(String leftStrand, String rightStrand) {
    	if (leftStrand.isEmpty() && !rightStrand.isEmpty()) {
    		throw new IllegalArgumentException("left strand must not be empty.");
    	}
    	if (rightStrand.isEmpty() && !leftStrand.isEmpty()) {
    		throw new IllegalArgumentException("right strand must not be empty.");
    	}
    	if (leftStrand.length() != rightStrand.length()) {
    		throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    	}
	}

	public int getHammingDistance() {
        return hammingDistance;
    }
    
}

