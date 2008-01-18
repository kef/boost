package au.net.netstorm.boost.test.automock;

public interface TestFieldInjector {
    void injectSubject(Object ref);

    void inject(Object ref);

    void verify();
}
