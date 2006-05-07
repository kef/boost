package au.net.netstorm.boost.util.instance;

import au.net.netstorm.boost.java.lang.reflect.ReflectEdge;

public class DefaultInstanceProvider implements InstanceProvider {
    private final ReflectEdge edge;

    public DefaultInstanceProvider(ReflectEdge edge) {
        this.edge = edge;
    }

    // FIXME: SC524 Test drive null check for cls.
    public Object newInstance(Class cls) {
        return edge.newInstance(cls);
    }

    // FIXME: SC524 Test drive these.
//    public Object newInstance(Class cls, Object argument, Class argumentType) {
//        throw new NotImplementedException();
//    }
//
//    public Object newInstance(Class aClass, Object[] arguments, Class[] argumentTypes) {
//        throw new NotImplementedException();
//    }
}
