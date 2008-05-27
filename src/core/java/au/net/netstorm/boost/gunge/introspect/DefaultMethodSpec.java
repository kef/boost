package au.net.netstorm.boost.gunge.introspect;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.gunge.nullo.DefaultNullMaster;
import au.net.netstorm.boost.gunge.nullo.NullMaster;

public final class DefaultMethodSpec extends Primordial implements MethodSpec {
    private NullMaster master = new DefaultNullMaster();
    private final String name;
    private final Class[] params;

    public DefaultMethodSpec(String name, Class[] params) {
        this.name = name;
        validate(params);
        this.params = params.clone();
    }

    private void validate(Class[] params) {
        master.check(name);
        master.check((Object[]) params);
    }

    public String getName() {
        return name;
    }

    public Class[] getParams() {
        return params.clone();
    }
}
