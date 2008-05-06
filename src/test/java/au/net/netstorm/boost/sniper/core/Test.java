package au.net.netstorm.boost.sniper.core;

public interface Test {
    String getName();

    // FIX 2318 Delete this.  Not used.
    void setName(String name);

    void runTest() throws Throwable;
}
