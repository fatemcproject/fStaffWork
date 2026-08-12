package io.fateproject.fstaffwork.util;

import java.text.NumberFormat;
import java.util.Locale;

public final class StringUtil {

    public String reparse(long value, ResultType resultType){

        Locale locale = Locale.CANADA;

        switch (resultType){
            case DOT:
                locale = Locale.GERMAN;
                break;

            case COMMA:
                locale = Locale.US;
                break;
        }

        NumberFormat numberFormat = NumberFormat.getInstance(locale);

        return numberFormat.format(value);
    }

    public enum ResultType {
        DOT,
        COMMA
    }
}
