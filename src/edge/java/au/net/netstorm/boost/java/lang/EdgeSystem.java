/*
 * Copyright (C) 2005 Transtoll Pty Limited.
 */
package au.net.netstorm.boost.java.lang;

public interface EdgeSystem {
    EdgeSystem INSTANCE = new DefaultEdgeSystem();

    String getProperty(String key);
}
