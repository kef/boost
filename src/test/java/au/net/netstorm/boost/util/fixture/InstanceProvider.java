/*
 * Copyright (C) 2005 Transtoll Pty Limited.
 */
package au.net.netstorm.boost.util.fixture;

public interface InstanceProvider {
    Object getInstance(Class type);
    boolean canProvider(Class type);
}
