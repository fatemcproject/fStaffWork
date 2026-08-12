package io.fateproject.fstaffwork.util;

import io.fateproject.fstaffwork.services.impl.StaffWorkService;
import org.bukkit.Bukkit;

import java.text.NumberFormat;
import java.util.Locale;

public final class StringUtil {

    public String reparse(long value, ResultType resultType) {
        return NumberFormat.getInstance(resultType == ResultType.DOT ? Locale.GERMAN : Locale.US).format(value);
    }

    public enum ResultType {
        DOT,
        COMMA
    }
}
