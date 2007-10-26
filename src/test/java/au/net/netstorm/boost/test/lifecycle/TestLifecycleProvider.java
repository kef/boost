package au.net.netstorm.boost.test.lifecycle;

public interface TestLifecycleProvider {
    // FIX 2180 Rename to methodTest...
    MethodTestLifecycle classTestLifecycle();

    ThreadTestLifecycle threadTestLifecycle();
}
