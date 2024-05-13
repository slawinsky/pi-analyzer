package backend.pianalyzer.pianalyzer.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Date;

@Service
public class ZonedDateTimeWriteConverter implements Converter<ZonedDateTime, Date> {
    @Override
    public Date convert(ZonedDateTime zonedDateTime) {
        return Date.from(zonedDateTime.toInstant());
    }
}