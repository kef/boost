package au.net.netstorm.boost.retire.reflect;

public interface AssertThrows {
    Throwable assertThrows(Class expectedException, String message, Runnable block);

    Throwable assertThrows(Class expectedException, Runnable block);

    void assertMessageContains(Throwable t, String fragment);
}
