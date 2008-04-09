package au.net.netstorm.boost.sniper.automock;

public interface TestFieldInjector {
    void injectSubject(Object ref);

    void inject(Object ref);

    void verify();
}
