package au.net.netstorm.boost.nursery.reflect.checker;

public interface AssertThrows {
    Throwable assertThrows(Class expectedException, String message, Block block);

    Throwable assertThrows(Class expectedException, Block block);

    void assertMessageContains(Throwable t, String fragment);
}
