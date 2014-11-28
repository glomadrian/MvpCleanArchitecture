package com.github.glomadrian.mvpcleanarchitecture.domain;

/**
 * @author glomadrian
 */
public class LogUtils {

    private LogUtils() {
        //You shall not pass
    }

    public static String generateTag(Object object) {
        return object.getClass().getCanonicalName();
    }
}
