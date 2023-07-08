import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class HighScores {

    private List<Integer> highScores;

    public HighScores(List<Integer> highScores) {
    	this.highScores = highScores;
    }

    List<Integer> scores() {
    	return highScores;
    }

    Integer latest() {
    	return highScores.get(highScores.size() - 1);
    }

    Integer personalBest() {
    	return highScores.stream().max(Comparator.comparingInt(Integer::intValue)).get();
    }

    List<Integer> personalTopThree() {
    	return highScores.stream().sorted(Collections.reverseOrder()).limit(3).toList();
    }

}

