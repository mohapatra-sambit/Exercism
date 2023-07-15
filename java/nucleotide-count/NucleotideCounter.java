import java.util.HashMap;
import java.util.Map;

class NucleotideCounter {
	
	private Map<Character, Integer> nucleotideMap;
	
	{
		nucleotideMap = new HashMap<Character, Integer>();
		nucleotideMap.put('A', 0);
		nucleotideMap.put('C', 0);
		nucleotideMap.put('G', 0);
		nucleotideMap.put('T', 0);
	}
	
	public NucleotideCounter(String nucleotide) {
		nucleotide.chars().forEach(i -> {
			switch((char) i) {
			case 'A':
			case 'C':
			case 'G':
			case 'T':
				nucleotideMap.put((char)i, nucleotideMap.get((char) i) + 1);
				break;
			default:
				throw new IllegalArgumentException();
			}
		});
	}

	public Map<Character, Integer> nucleotideCounts() {
		return nucleotideMap;
	}
	
}
