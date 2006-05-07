/*
 * Copyright (C) 2005 Transtoll Pty Limited.
 */
package au.net.netstorm.boost.java.lang;

public final class EdgeSystem implements System {
    public String getProperty(String key) {
        return java.lang
                .System
                .getProperty(key);
    }
}
