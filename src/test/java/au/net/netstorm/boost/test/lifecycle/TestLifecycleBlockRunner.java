package au.net.netstorm.boost.test.lifecycle;

public interface TestLifecycleBlockRunner {
    void pre();

    void post();

    void cleanup();
}
