package com.sankaran.ssm.admin.utils;

import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.CaseUtils;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
@FunctionalInterface
public interface SSMUtil {
    String ymdFormat="yyyy-MM-dd";
    String iso8610Format="yyyy-MM-dd'T'HH:mm:ss. SSSXXX";
    void dummyAbstractMethod();
    static String ObjectToString(Object obj){
        return String.valueOf(obj);
    }

    static Integer ObjectToInteger(Object obj){
        if (!Objects.isNull(obj)){
            if (obj instanceof BigInteger)
                return ((BigInteger) obj).intValue();
            else if (obj instanceof Integer)
                return (Integer) obj;
        }
        return 0;
    }

    static Long ObjectToLong(Object obj){
        if (!Objects.isNull(obj)){
            if (obj instanceof BigInteger)
                return ((BigInteger) obj).longValue();
            else if (obj instanceof Integer)
                return ((Integer) obj).longValue();
            else if (obj instanceof Long)
                return (Long) obj;
        }
        return 0l;
    }

    static LocalDate getCurrentDate(){
        return LocalDate.now();
    }

    static String getCurrentDateString(){
        return LocalDate.now().format(DateTimeFormatter.ofPattern("YYYY-MM-DD"));
    }

    static Long castStringToLong(String value){
        try {
            Long longValue = Long.parseLong(value);
            return longValue;
        }catch (NumberFormatException nfe){
            return null;
        }
    }

    static String convertCodeToValue(String code){
        if (!Objects.isNull(code)){
            code = CaseUtils.toCamelCase(code, true,'_');
            code = String.join(" ", StringUtils.splitByCharacterTypeCamelCase(code));
            return code;
        }else {
            return code;
        }
    }

    static String convertValueToCode(String value){
        if (!Objects.isNull(value)){
            value = StringUtils.replace(value," ","_");
            return value.toUpperCase();
        }else {
            return value;
        }
    }

    static String convertLocalDateToString(LocalDate date, String format){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        if (!Objects.isNull(date))
            return formatter.format(date);
        else
            return null;
    }

}
