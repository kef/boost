package au.net.netstorm.boost.sniper.automock;

public interface TestFieldInjector {
    void initSubject(Object ref);

    void injectSubject(Object ref);

    void injectTestDoubles(Object ref);

    void verify();
}
