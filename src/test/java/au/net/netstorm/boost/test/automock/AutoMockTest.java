package au.net.netstorm.boost.test.automock;

public interface AutoMockTest {
    void injectSubject();

    void setExpectField();

    void injectAutoMocks();

    void validate();

    void verify();
}
