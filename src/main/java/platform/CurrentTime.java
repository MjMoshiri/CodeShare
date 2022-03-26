package platform;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentTime {
    private static final String DATE_FORMATTER = "yyyy-MM-dd HH:mm:ss";
    static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);

    @Override
    public String toString() {
        return LocalDateTime.now().format(formatter);
    }

    public LocalDateTime now() {
        return LocalDateTime.now();
    }

    public static String returnString(LocalDateTime t) {
        return t.format(formatter);
    }
}
