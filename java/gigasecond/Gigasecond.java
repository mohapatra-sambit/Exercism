import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Gigasecond {
    private LocalDateTime newLocalDateTime;

	public Gigasecond(LocalDate moment) {
		LocalDateTime tempDateTime = moment.atStartOfDay();
		newLocalDateTime = tempDateTime.plus(1000000000, ChronoUnit.SECONDS);
    }

    public Gigasecond(LocalDateTime moment) {
    	newLocalDateTime = moment.plus(1000000000, ChronoUnit.SECONDS);
    }

    public LocalDateTime getDateTime() {
        return newLocalDateTime;
    }
}

