package com.skillbox.socialnetwork.main.converter;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneOffset;

@Component
public class DateConvert {

    public long dateToLong(LocalDate localDate) {
        return localDate != null ? localDate.atStartOfDay(ZoneOffset.UTC).toEpochSecond() * 1000 : 0;
    }
    public LocalDate longToDate(long epochMillis) {
        return LocalDate.ofEpochDay(epochMillis/86_400_000);
    }

}
