package org.littlesun.controller;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*日期转换器*/
public class DateConvert implements Converter<String, Date> {
    SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public Date convert(String source) {

        try {
            return sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
