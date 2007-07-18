package au.net.netstorm.boost.test.automock;

public interface TestFieldInjector {
    void injectSubject();

    void setExpectField();

    void inject();

    void validate();

    void verify();
}
