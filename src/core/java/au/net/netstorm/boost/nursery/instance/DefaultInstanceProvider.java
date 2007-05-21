package au.net.netstorm.boost.nursery.instance;

import au.net.netstorm.boost.edge.java.lang.EdgeClass;

// FIX 1524 Remove this 
public class DefaultInstanceProvider implements InstanceProvider {
    private final EdgeClass edge;

    public DefaultInstanceProvider(EdgeClass edge) {
        this.edge = edge;
    }

    // SUGGEST Test drive null check for cls.
    public Object newInstance(Class cls) {
        return edge.newInstance(cls);
    }

    // SUGGEST Test drive these.
//    public Object newInstance(Class cls, Object argument, Class argumentType) {
//        throw new NotImplementedException();
//    }
//
//    public Object newInstance(Class aClass, Object[] arguments, Class[] argumentTypes) {
//        throw new NotImplementedException();
//    }
}
