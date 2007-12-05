package au.net.netstorm.boost.nursery.type.core;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.equals.ArraysEqualsMaster;
import au.net.netstorm.boost.util.equals.DefaultArraysEqualsMaster;
import au.net.netstorm.boost.util.introspect.DefaultFieldValueSpec;
import au.net.netstorm.boost.util.introspect.FieldValueSpec;
import au.net.netstorm.boost.util.tostring.IndentingToStringMaster;
import au.net.netstorm.boost.util.tostring.ToStringMaster;
import au.net.netstorm.boost.util.type.DefaultMarker;
import au.net.netstorm.boost.util.type.Marker;
import au.net.netstorm.boost.util.type.Sensitive;

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
        // FIX (Nov 23, 2007) 2233 Atomically test null.
        if (value == null) throw new IllegalArgumentException();
        this.value = cloneIfArray(value);
    }

    public final T getValue() {
        return cloneIfArray(value);
    }

    private T cloneIfArray(T value) {
        Class<?> cls = value.getClass();
        if (cls.isArray()) return cloneArray(value);
        return value;
    }

    private <T> T cloneArray(T ref) {
        // SUGGEST (Nov 23, 2007): Avoid adding more.
        return (T) ((byte[]) ref).clone();
    }

    // FIX (Nov 22, 2007) 2233 Ensure tests make these final.
    // FIX (Nov 21, 2007) 2233 Equals/HashCode were just hacked.

    public final boolean equals(Object o) {
        if (!(o instanceof Holder)) return false;
        Holder other = (Holder) o;
        Object otherValue = other.getValue();
        Class otherClass = otherValue.getClass();
        if (otherClass.isArray()) return ARRAYS_EQUALS.equals(otherValue, value);
        return value.equals(otherValue);
    }

    // FIX (Nov 21, 2007) 2233 Test and insure these are final.
    public final int hashCode() {
        return value.hashCode();
    }

    public final String toString() {
        // FIX (Nov 29, 2007) 2233 Change sensitive string to a hash of value.
        if (MARKER.is(this, Sensitive.class)) return "Like XXXX, totally unflavoured.";
        FieldValueSpec field = new DefaultFieldValueSpec("value", value);
        FieldValueSpec[] fields = {field};
        return TO_STRING_MASTER.formatFields(this, fields);
    }
}
// } OK GenericIllegalRegexp
