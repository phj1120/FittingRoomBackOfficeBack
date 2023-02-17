package org.plateer.fittingroombo.common.fomatter;

import lombok.extern.log4j.Log4j2;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * LocalDateTime 처리를 위한 Formatter
 * 작성자: 박현준
 * 일시: 2023-02-17
 * 버전: v1
 **/
@Log4j2
public class LocalDateTimeFormatter implements Formatter<LocalDateTime> {
    @Override
    public LocalDateTime parse(String text, Locale locale) throws ParseException {
        LocalDateTime result = LocalDateTime.parse(text, DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        log.info("[LocalDateTimeFormatter]");
        log.info("{} -> {}", text, result);
        return result;
    }

    @Override
    public String print(LocalDateTime object, Locale locale) {
        return null;
    }
}
