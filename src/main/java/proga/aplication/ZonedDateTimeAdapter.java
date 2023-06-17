package proga.aplication;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.ZonedDateTime;

/**
 * Represents date adapter.
 */
public class ZonedDateTimeAdapter extends XmlAdapter<String, ZonedDateTime> {
    public String marshal(ZonedDateTime zonedDateTime) {
        return zonedDateTime.toString();
    }
    public ZonedDateTime unmarshal(String v) {
        return ZonedDateTime.parse(v);
    }

}