import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

class ResistorColor {

	private Map<String, Integer> colorMap;

	public ResistorColor() {
		colorMap = new LinkedHashMap<>();
		colorMap.put("black", 0);
		colorMap.put("brown", 1);
		colorMap.put("red", 2);
		colorMap.put("orange", 3);
		colorMap.put("yellow", 4);
		colorMap.put("green", 5);
		colorMap.put("blue", 6);
		colorMap.put("violet", 7);
		colorMap.put("grey", 8);
		colorMap.put("white", 9);
	}

	int colorCode(String color) {
		return colorMap.get(color);
	}

	String[] colors() {
		return Arrays.stream(colorMap.keySet().toArray()).toArray(String[]::new);
	}
}

