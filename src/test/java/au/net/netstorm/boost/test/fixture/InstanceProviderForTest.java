package au.net.netstorm.boost.test.fixture;

public interface InstanceProviderForTest {
    Object getInstance(Class type);
    boolean canProvide(Class type);
}
