package com.tenilodev.indekos.utils;

import java.lang.reflect.Type;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class DateDeserializer implements JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonElement element, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {


        return new Date(Long.valueOf(element.getAsString()));
//        String date = element.getAsString();
//
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
//        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
//
//        try {
//            return formatter.parse(date);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            return null;
//        }
    }
}