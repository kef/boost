package au.net.netstorm.boost.sniper.automock;

public interface TestFieldInjector {
    void injectSubject(Object ref);

    // FIX 2328 add method to inject reals and wire into InjectTest
    void injectReals(Object ref);

    void injectTestDoubles(Object ref);

    void verify();
}
