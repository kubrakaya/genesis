package com.mobiliz.portal.TestRail;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface UseAsTestRailIdSet {

    String[] testRailCaseId() default "";

    String testRailRunId() default "";

}