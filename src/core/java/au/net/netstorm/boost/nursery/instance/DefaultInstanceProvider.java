package au.net.netstorm.boost.nursery.instance;

import au.net.netstorm.boost.edge.java.lang.EdgeClass;

public class DefaultInstanceProvider implements InstanceProvider {
    private final EdgeClass edge;

    public DefaultInstanceProvider(EdgeClass edge) {
        this.edge = edge;
    }

    // FIX SC524 Test drive null check for cls.
    public Object newInstance(Class cls) {
        return edge.newInstance(cls);
    }

    // FIX SC524 Test drive these.
//    public Object newInstance(Class cls, Object argument, Class argumentType) {
//        throw new NotImplementedException();
//    }
//
//    public Object newInstance(Class aClass, Object[] arguments, Class[] argumentTypes) {
//        throw new NotImplementedException();
//    }
}
