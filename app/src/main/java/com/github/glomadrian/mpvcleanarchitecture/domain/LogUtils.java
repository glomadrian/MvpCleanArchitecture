package com.github.glomadrian.mpvcleanarchitecture.domain;

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
