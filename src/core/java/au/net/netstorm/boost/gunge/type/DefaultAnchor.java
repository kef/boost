package au.net.netstorm.boost.gunge.type;

import java.lang.reflect.Field;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.gunge.nullo.DefaultNullMaster;
import au.net.netstorm.boost.gunge.nullo.NullMaster;

public final class DefaultAnchor extends Primordial implements Anchor {
    private final NullMaster nuller = new DefaultNullMaster();
    private final Field field;

    public DefaultAnchor(Field field) {
        this.field = field;
        nuller.check(field, "field");
    }

    public Field getField() {
        return field;
    }
}
