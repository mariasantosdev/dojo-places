package br.com.alura.dojoplaces.place.utils;

import br.com.alura.dojoplaces.utils.OffsetDateTimeUtil;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OffsetDateTimeUtilTest {

    @Test
    void formatOffsetDateTime__should_return_formatted_date() {
        OffsetDateTime offsetDateTime = OffsetDateTime.of(2021, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        String expected = "01/01/2021";

        String actual = OffsetDateTimeUtil.formatOffsetDateTime(offsetDateTime);

        assertEquals(expected, actual);
    }

}