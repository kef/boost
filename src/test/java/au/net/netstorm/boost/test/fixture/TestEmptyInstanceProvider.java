package au.net.netstorm.boost.test.fixture;

public final class TestEmptyInstanceProvider implements InstanceProvider {
    public Object getInstance(Class type) {
        throw new RuntimeException("We do not provide any instances.");
    }

    public boolean canProvide(Class type) {
        return false;
    }
}
