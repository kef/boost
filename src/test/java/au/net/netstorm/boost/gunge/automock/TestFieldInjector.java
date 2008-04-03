package au.net.netstorm.boost.gunge.automock;

public interface TestFieldInjector {
    void injectSubject(Object ref);

    void inject(Object ref);

    void verify();
}
