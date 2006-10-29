package au.net.netstorm.boost.test.automock;

interface TestLifecycle {
    void init();

    void verify();

    void destroy();
}
