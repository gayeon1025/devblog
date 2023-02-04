package com.cnu.devblog.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeSerializer extends JsonSerializer<ZonedDateTime> {
    @Override
    public void serialize(ZonedDateTime date, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedString = date.format(formatter);
        gen.writeString(formattedString);
    }
}
