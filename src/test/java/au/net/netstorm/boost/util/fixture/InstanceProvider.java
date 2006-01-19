package au.net.netstorm.boost.util.fixture;

public interface InstanceProvider {
    Object getInstance(Class type);
    boolean canProvide(Class type);
}
