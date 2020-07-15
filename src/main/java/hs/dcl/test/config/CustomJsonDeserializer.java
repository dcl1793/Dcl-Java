package hs.dcl.test.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zhangbro
 */
@NoArgsConstructor
@Slf4j
public class CustomJsonDeserializer {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter DATE_TIME_SORT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static class DateJsonSerializer extends JsonDeserializer<LocalDateTime> {
        @Override
        public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            String time = p.readValueAs(String.class);
            try {
                return LocalDateTime.from(DATE_TIME_FORMATTER.parse(time));
            } catch (Exception e) {
                log.error("", e);
                return null;
            }
        }
    }

    public static class DateSort extends JsonDeserializer<LocalDateTime> {

        @Override
        public LocalDateTime deserialize(JsonParser p, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            String time = p.readValueAs(String.class);
            try {

                return LocalDateTime.from(DATE_TIME_FORMATTER.parse(time));

            } catch (Exception e) {
                log.error("", e);
                return null;
            }
        }
    }
}
