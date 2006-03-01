package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Data;

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
