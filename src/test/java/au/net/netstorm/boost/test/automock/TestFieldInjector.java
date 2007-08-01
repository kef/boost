package au.net.netstorm.boost.test.automock;

public interface TestFieldInjector {
    void injectSubject();

    void inject();

    void verify();
}
