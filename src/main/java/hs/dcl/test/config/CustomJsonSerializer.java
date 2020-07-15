package hs.dcl.test.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author zhangbro
 */
@NoArgsConstructor
public class CustomJsonSerializer {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static class DateTime extends JsonSerializer<LocalDateTime> {
        @Override
        public void serialize(LocalDateTime val, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (val == null) {
                jsonGenerator.writeString("");
            } else {
                jsonGenerator.writeString(DATE_TIME_FORMATTER.format(val));
            }
        }
    }
    
    
    public static class DateShort extends JsonSerializer<LocalDateTime> {
        @Override
        public void serialize(LocalDateTime val, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (val == null) {
                jsonGenerator.writeString("");
            } else {
                jsonGenerator.writeString(DATE_FORMAT.format(val));
            }
        }
    }
}
