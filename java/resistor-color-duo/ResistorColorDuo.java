import java.util.LinkedHashMap;
import java.util.Map;

class ResistorColorDuo {

	private Map<String, Integer> colorMap;

	public ResistorColorDuo() {
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

	int value(String[] colors) {
		return (colorMap.get(colors[0]) * 10) + colorMap.get(colors[1]);
	}
}

