package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Data;
import au.net.netstorm.boost.util.nullo.NullMaster;

public final class CallSpec extends Primordial implements Data {
    private final String methodName;
    private final Class[] argTypes;
    private final Object[] args;

    public CallSpec(String methodName, Class[] argTypes, Object[] args) {
        NullMaster.check(methodName);
        NullMaster.check(argTypes);
        NullMaster.check(args);
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
