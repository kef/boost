package au.net.netstorm.boost.test.lifecycle;

public interface TestLifecycle {
    void classPre();

    void classPost();

    void classCleanup(boolean successful);

    void threadPre();

    void threadPost();

    void threadCleanup(boolean successful);
}
