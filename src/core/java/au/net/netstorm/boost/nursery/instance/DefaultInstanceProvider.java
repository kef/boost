package au.net.netstorm.boost.nursery.instance;

import au.net.netstorm.boost.edge.java.lang.reflect.EdgeReflect;

public class DefaultInstanceProvider implements InstanceProvider {
    private final EdgeReflect edge;

    public DefaultInstanceProvider(EdgeReflect edge) {
        this.edge = edge;
    }

    // FIXME: SC524 Test drive null check for cls.
//    public Object newInstance(Class cls) {
//        return edge.newInstance(cls);
//    }

    // FIXME: SC524 Test drive these.
//    public Object newInstance(Class cls, Object argument, Class argumentType) {
//        throw new NotImplementedException();
//    }
//
//    public Object newInstance(Class aClass, Object[] arguments, Class[] argumentTypes) {
//        throw new NotImplementedException();
//    }
}
