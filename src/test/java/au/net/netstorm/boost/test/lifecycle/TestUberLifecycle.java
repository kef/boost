package au.net.netstorm.boost.test.lifecycle;

public interface TestUberLifecycle {
    void pre();

    void post();

    void cleanup(boolean successful);
}