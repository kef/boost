package au.net.netstorm.boost.test.checker;

public interface AssertThrows {
    Throwable assertThrows(Class expectedException, String message, Block block);

    Throwable assertThrows(Class expectedException, Block block);

    void assertMessageContains(Throwable t, String fragment);
}
