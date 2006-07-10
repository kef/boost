package au.net.netstorm.boost.test.checker;

public interface AssertThrows {
    Throwable assertThrows(Class expectedException, String message, DefaultAssertThrows.Block block);

    Throwable assertThrows(Class expectedException, DefaultAssertThrows.Block block);

    void assertMessageContains(Throwable t, String fragment);
}
