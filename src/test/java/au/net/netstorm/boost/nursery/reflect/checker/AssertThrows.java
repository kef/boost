package au.net.netstorm.boost.nursery.reflect.checker;

public interface AssertThrows {
    Throwable assertThrows(Class expectedException, String message, Runnable block);

    Throwable assertThrows(Class expectedException, Runnable block);

    void assertMessageContains(Throwable t, String fragment);
}
