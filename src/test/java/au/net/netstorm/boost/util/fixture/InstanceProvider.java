package au.net.netstorm.boost.util.fixture;

// FIXME: SC524 Distinguish from util.instance.InstanceProvider.
public interface InstanceProvider {
    Object getInstance(Class type);
    boolean canProvide(Class type);
}
