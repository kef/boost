package au.net.netstorm.boost.sniper.automock;

public interface TestFieldInjector {
    void injectSubject(Object ref);

    void injectTestDoubles(Object ref);

    void verify();
}
