package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.nullo.DefaultNullMaster;
import au.net.netstorm.boost.util.nullo.NullMaster;
import au.net.netstorm.boost.util.type.Data;

// FIX SC524 Make an interface for this.
public final class MethodSpec extends Primordial implements Data {
    private NullMaster master = new DefaultNullMaster();
    private final String name;
    private final Class[] params;

    public MethodSpec(String name, Class[] params) {
        // FIX SC502 Move into validate(...) method.
        this.name = name;
        validate(params);
        this.params = (Class[]) params.clone();
    }

    private void validate(Class[] params) {
        master.check(name, "name");
        master.check(params, "params");
    }

    public String getName() {
        return name;
    }

    public Class[] getParams() {
        return (Class[]) params.clone();
    }
}
