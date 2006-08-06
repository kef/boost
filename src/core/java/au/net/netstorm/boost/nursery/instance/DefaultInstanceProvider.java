package au.net.netstorm.boost.nursery.instance;

public DefaultInstanceProvider implements InstanceProvider {
    private final EdgeClass edge;

    public DefaultInstanceProvider(EdgeClass edge) {
        this.edge = edge;
    }

    // FIXME: SC524 Test drive null check for cls.
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
