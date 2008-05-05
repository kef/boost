package au.net.netstorm.boost.gunge.introspect;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.gunge.type.Data;

public final class DefaultFieldSpec extends Primordial implements FieldSpec, Data {
    private final String name;
    private final Class type;

    public DefaultFieldSpec(String name, Class type) {
        if (name == null) throw new IllegalArgumentException();
        if (type == null) throw new IllegalArgumentException();
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Class getType() {
        return type;
    }
}
