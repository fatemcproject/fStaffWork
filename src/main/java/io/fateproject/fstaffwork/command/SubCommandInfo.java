package io.fateproject.fstaffwork.command;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SubCommandInfo {

    String[] aliases();

    String permission() default "";
    String description() default "N/a description";

}
