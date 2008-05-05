package au.net.netstorm.boost.nursery.type.core;

import au.net.netstorm.boost.bullet.primmm.Primordial;
import au.net.netstorm.boost.gunge.equals.ArraysEqualsMaster;
import au.net.netstorm.boost.gunge.introspect.DefaultFieldValueSpec;
import au.net.netstorm.boost.gunge.introspect.FieldValueSpec;
import au.net.netstorm.boost.gunge.tostring.ToStringMaster;
import au.net.netstorm.boost.gunge.type.DefaultMarker;
import au.net.netstorm.boost.gunge.type.Marker;
import au.net.netstorm.boost.gunge.type.Sensitive;
import au.net.netstorm.boost.nursery.gunge.equals.DefaultArraysEqualsMaster;
import au.net.netstorm.boost.nursery.gunge.tostring.IndentingToStringMaster;

// FIX 2233 Pull out array cloning and delegate - alternatively DefaultArrayHolder<T>?
// FIX (Nov 21, 2007) 2233 Needs testing.
// FIX (Nov 21, 2007) 2233 Move out of nursery

// OK GenericIllegalRegexp {
public abstract class DefaultHolder<T> extends Primordial implements Holder<T> {
    private static final ArraysEqualsMaster ARRAYS_EQUALS = new DefaultArraysEqualsMaster();
    private static final ToStringMaster TO_STRING_MASTER = new IndentingToStringMaster();
    private static final Marker MARKER = new DefaultMarker();
    private final T value;

    public DefaultHolder(T value) {
        // FIX (Nov 23, 2007) 2233 Atomically test null.
        if (value == null) throw new IllegalArgumentException();
        this.value = cloneIfArray(value);
    }

    public final T getValue() {
        return cloneIfArray(value);
    }

    // FIX (Nov 22, 2007) 2233 Ensure tests make these final.
    // FIX (Nov 21, 2007) 2233 Equals/HashCode were just hacked.
    public final boolean equals(Object o) {
        if (!(o instanceof DefaultHolder)) return false;
        Object value = ((DefaultHolder) o).getValue();
        Class cls = value.getClass();
        if (cls.isArray()) return ARRAYS_EQUALS.equals(value, this.value);
        return this.value.equals(value);
    }

    // FIX (Nov 21, 2007) 2233 Test and ensure these are final.
    public final int hashCode() {
        return value.hashCode();
    }

    public final String toString() {
        if (MARKER.is(this, Sensitive.class)) return "Like XXXX, totally unflavoured.";
        FieldValueSpec field = new DefaultFieldValueSpec("value", value);
        FieldValueSpec[] fields = {field};
        return TO_STRING_MASTER.formatFields(this, fields);
    }

    private T cloneIfArray(T value) {
        Class<?> cls = value.getClass();
        if (!cls.isArray()) return value;
        return cloneArray(value);
    }

    private T cloneArray(T value) {
        if (value instanceof byte[]) return cloneBytes(value);
        throw new IllegalArgumentException();
    }

    private T cloneBytes(T value) {
        byte[] bytes = (byte[]) value;
        return (T) bytes.clone();
    }
}
// } OK GenericIllegalRegexp
