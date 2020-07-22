package com.mobiliz.portal.TestRail;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface UseAsTestRailId
{
    int[] testRailCaseId() default 0;
    int testRailRunId() default 0;
    String[] tags() default "";
}