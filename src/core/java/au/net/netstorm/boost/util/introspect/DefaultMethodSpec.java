package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.nullo.DefaultNullMaster;
import au.net.netstorm.boost.util.nullo.NullMaster;

// FIX SC524 Make an interface for this.
public final class DefaultMethodSpec extends Primordial implements MethodSpec {
    private NullMaster master = new DefaultNullMaster();
    private final String name;
    private final Class[] params;

    public DefaultMethodSpec(String name, Class[] params) {
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
