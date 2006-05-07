/*
 * Copyright (C) 2005 Transtoll Pty Limited.
 */
package au.net.netstorm.boost.java.lang;

public interface System {
    System INSTANCE = new EdgeSystem();

    String getProperty(String key);
}
