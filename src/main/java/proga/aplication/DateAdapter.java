package proga.aplication;

import java.time.ZonedDateTime;

public class DateAdapter {

    public static String marshal(ZonedDateTime zonedDateTime) {
        return zonedDateTime.toString();
    }

    public static ZonedDateTime unmarshal(String v) {
        return ZonedDateTime.parse(v);
    }

}