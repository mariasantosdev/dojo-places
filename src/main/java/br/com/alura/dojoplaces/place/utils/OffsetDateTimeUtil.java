package br.com.alura.dojoplaces.place.utils;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class OffsetDateTimeUtil {
    public static String formatOffsetDateTime(OffsetDateTime offsetDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return offsetDateTime.format(formatter);
    }
}
