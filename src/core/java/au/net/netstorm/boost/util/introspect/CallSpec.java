package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.nullo.NullMaster;
import au.net.netstorm.boost.util.type.Data;

public final class CallSpec extends Primordial implements Data {
    private final String methodName;
    private final Class[] argTypes;
    private final Object[] args;

    // FIXME: SC042 This is not really a CallSpec.  Expect a CallSpec to look like: (ref, methodName, Object[])
    public CallSpec(String methodName, Class[] argTypes, Object[] args) {
        // FIXME: SC502 Move into separate method validate(...).
        NullMaster master = new NullMaster();
        master.check(methodName);
        master.check(argTypes);
        master.check(args);
        this.methodName = methodName;
        this.argTypes = (Class[]) argTypes.clone();
        this.args = (Object[]) args.clone();
    }

    public String getMethodName() {
        return methodName;
    }

    public Class[] getArgTypes() {
        return (Class[]) argTypes.clone();
    }

    public Object[] getArgs() {
        return (Object[]) args.clone();
    }
}
