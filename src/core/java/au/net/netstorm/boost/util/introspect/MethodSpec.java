package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.util.type.Data;
import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.nullo.NullMaster;

public final class MethodSpec extends Primordial implements Data {
    private final String name;
    private final Class[] params;

    public MethodSpec(String name, Class[] params) {
        NullMaster.check(name);
        NullMaster.check(params);
        this.name = name;
        this.params = (Class[]) params.clone();
    }

    public String getName() {
        return name;
    }

    public Class[] getParams() {
        return (Class[]) params.clone();
    }
}
