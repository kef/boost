package au.net.netstorm.boost.test.automock;

public interface TestFieldInjector {
    void injectSubject();

    void setExpectField();

    void injectLazyFields();

    void validate();

    void verify();
}
