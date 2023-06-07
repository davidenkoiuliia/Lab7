package server.services;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The type Local date time adapter.
 */
public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @Override
    public LocalDateTime unmarshal(String v) throws Exception {
        return LocalDateTime.parse(v, DATE_TIME_FORMATTER);
    }

    @Override
    public String marshal(LocalDateTime v) throws Exception {
        return v.format(DATE_TIME_FORMATTER);
    }
}
