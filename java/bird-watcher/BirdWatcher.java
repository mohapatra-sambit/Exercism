import java.util.Calendar;
import java.util.GregorianCalendar;

class BirdWatcher {

	private final int[] birdsPerDay;

	public BirdWatcher(int[] birdsPerDay) {
		this.birdsPerDay = birdsPerDay.clone();
	}

	public int[] getLastWeek() {
		return birdsPerDay;
	}

	public int getToday() {
		if (birdsPerDay.length == 0) {
			return 0;
		}
		return birdsPerDay[new GregorianCalendar().get(Calendar.DAY_OF_WEEK) - 1];
	}

	public void incrementTodaysCount() {
		int today = new GregorianCalendar().get(Calendar.DAY_OF_WEEK) - 1;
		++birdsPerDay[today];
	}

	public boolean hasDayWithoutBirds() {
		for (int i : birdsPerDay) {
			if (i == 0) {
				return true;
			}
		}
		return false;
	}

	public int getCountForFirstDays(int numberOfDays) {
		int total = 0;
		for (int i = 0; i < (numberOfDays > birdsPerDay.length ? birdsPerDay.length : numberOfDays); i++) {
			total += birdsPerDay[i];
		}
		return total;
	}

	public int getBusyDays() {
		int count = 0;
		for (int i : birdsPerDay) {
			if (i >= 5) {
				count++;
			}
		}
		return count;
	}
}
