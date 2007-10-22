package au.net.netstorm.boost.test.lifecycle;

public interface TestLifecycle {
    void classPre();

    void classPost();

    void testPre();

    void testPost();

    void cleanup(boolean successful);
}
