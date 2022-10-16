import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class StreamsTimeModule {
    public static void main(String[] args) {
        // Create a programme to show current time of various world cities, across all the timezones.
        /*
        Sydney / Jakarta / Delhi / Dubai / London / Spain / New York / Chicago / SanFransisco
        */
        // get current time
        LocalTime timeLocalNow = LocalTime.now();
        LocalDateTime dtLocalNow = LocalDateTime.now();
        System.out.println("timeLocalNow: "+timeLocalNow);
        System.out.println("dtLocalNow: "+dtLocalNow);

        // zoned times
        List<ZoneId> zoneIdList = new ArrayList<>();

        System.out.println("dtZonedNow (default): "+ ZonedDateTime.now());
        System.out.println("Sydney: "+ZonedDateTime.of(dtLocalNow,ZoneId.of("Australia/Sydney")));
        System.out.println("Jakarta: "+ZonedDateTime.of(dtLocalNow,ZoneId.of("Asia/Jakarta")));
//        System.out.println("Delhi: "+ZonedDateTime.of(dtLocalNow,ZoneId.of("Asia/Delhi")));
        System.out.println("Dubai: "+ZonedDateTime.of(dtLocalNow,ZoneId.of("Asia/Dubai")));
        System.out.println("London: "+ZonedDateTime.of(dtLocalNow,ZoneId.of("Europe/London")));
//        System.out.println("Spain: "+ZonedDateTime.of(dtLocalNow,ZoneId.of("Europe/Spain")));
        System.out.println("New York: "+ZonedDateTime.of(dtLocalNow,ZoneId.of("America/New_York")));
        System.out.println("Chicago: "+ZonedDateTime.of(dtLocalNow,ZoneId.of("America/Chicago")));
//        System.out.println("San Francisco: "+ZonedDateTime.of(dtLocalNow,ZoneId.of("America/San_Francisco")));
    }
}

