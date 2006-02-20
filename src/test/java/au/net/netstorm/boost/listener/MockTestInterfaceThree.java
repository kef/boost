/*
 * Copyright (C) 2005 Transtoll Pty Limited.
 */
package au.net.netstorm.boost.listener;

public final class MockTestInterfaceThree implements TestInterfaceThree {
    private CloneNotSupportedException ex;

    public void barf() throws CloneNotSupportedException {
        throw ex;
    }

    public void init(CloneNotSupportedException ex) {
        this.ex = ex;
    }
}
