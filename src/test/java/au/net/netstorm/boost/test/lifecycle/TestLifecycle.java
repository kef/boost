package au.net.netstorm.boost.test.lifecycle;

// FIX 2000 Split into two interfaces.

// FIX 2000 More than that it looks like one interface used twice.
public interface TestLifecycle {
    void pre();

    void post();

    void cleanup(boolean successful);
}