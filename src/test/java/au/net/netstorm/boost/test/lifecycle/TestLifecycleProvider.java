package au.net.netstorm.boost.test.lifecycle;

public interface TestLifecycleProvider {
    TestLifecycle testLifecycle();

    ThreadTestLifecycle threadTestLifecycle();
}
