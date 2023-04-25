import java.time.Duration;
import java.time.Instant;

public class MeasureTime {
    static long measureTime(Runnable action) {
        Instant start = Instant.now();
        long durationMillis;
        try {
            action.run();
        } finally {
            Instant end = Instant.now();
            durationMillis =  Duration.between(start, end).toMillis();
        }
        return durationMillis;
    }
}
