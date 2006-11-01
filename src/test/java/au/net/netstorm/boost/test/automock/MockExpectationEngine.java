package au.net.netstorm.boost.test.automock;

interface MockExpectationEngine {
    void oneCall(Object ref, MockMethodSpec spec);

    void manyCalls(Object ref, MockMethodSpec spec);

    void oneCall(Object ref, Throwable throwable, String methodName, Object[] parameters);
}
