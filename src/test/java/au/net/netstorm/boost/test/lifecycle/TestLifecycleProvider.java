package au.net.netstorm.boost.test.lifecycle;

public interface TestLifecycleProvider {
    MethodTestLifecycle classTestLifecycle();

    ThreadTestLifecycle threadTestLifecycle();
}
