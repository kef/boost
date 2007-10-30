package au.net.netstorm.boost.test.core;

public interface RunnableTest {
    String getName();

    void runTest() throws Throwable;
}
