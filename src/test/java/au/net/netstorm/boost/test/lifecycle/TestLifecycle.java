package au.net.netstorm.boost.test.lifecycle;

public interface TestLifecycle {
    void testPre();

    void testPost();

    void cleanup(boolean successful);
}
