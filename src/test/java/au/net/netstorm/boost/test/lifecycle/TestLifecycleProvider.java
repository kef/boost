package au.net.netstorm.boost.test.lifecycle;

public interface TestLifecycleProvider {
    ClassTestLifecycle classTestLifecycle();

    ThreadTestLifecycle threadTestLifecycle();
}
