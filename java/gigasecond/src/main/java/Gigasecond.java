import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Created by anicholson on 5/11/17.
 */
public class Gigasecond {
    private static final int ONE_BILLION = 1000000000;

    private LocalDateTime date;

    public Gigasecond(LocalDate startDate) {
        date = addGigasecond(startDate.atStartOfDay());
    }

    public Gigasecond(LocalDateTime startTime) {
        date = addGigasecond(startTime);
    }

    private LocalDateTime addGigasecond(LocalDateTime localDateTime) {
        return localDateTime.plus(ONE_BILLION, ChronoUnit.SECONDS);
    }


    public LocalDateTime getDate() {
        return date;
    }
}
