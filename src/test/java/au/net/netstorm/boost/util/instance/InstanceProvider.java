package au.net.netstorm.boost.util.instance;

public interface InstanceProvider {
    Object newInstance(Class cls);

    // FIXME: SC524 Test drive these.
//    Object newInstance(Class cls, Object argument, Class argumentType);

//    Object newInstance(Class aClass, Object[] arguments, Class[] argumentTypes);
}
