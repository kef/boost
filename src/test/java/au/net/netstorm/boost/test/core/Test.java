package au.net.netstorm.boost.test.core;

public interface Test {
    String getName();

    void setName(String name);

    void runTest() throws Throwable;
}
