package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.nullo.NullMaster;
import au.net.netstorm.boost.util.type.Data;

public final class MethodSpec extends Primordial implements Data {
    private final String name;
    private final Class[] params;

    public MethodSpec(String name, Class[] params) {
        // FIXME: SC502 Move into validate(...) method.
        NullMaster master = new NullMaster();
        master.check(name);
        master.check(params);
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
