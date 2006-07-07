package au.net.netstorm.boost.util.introspect;

import java.lang.reflect.Array;

import au.net.netstorm.boost.util.nullo.NullMaster;
import au.net.netstorm.boost.util.type.Immutable;

// FIXME: SC502 Who uses this.  Do we need it?
// FIXME: SC506 Can just be an immutable.
public class DefaultFieldValueSpec implements Immutable, FieldValueSpec {
    private final String name;
    private final Object value;

    public DefaultFieldValueSpec(String name, Object value) {
        this.name = name;
        this.value = value;
        validate();
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    // FIXME: SC509 TEST DRIVE THIS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public boolean equals(Object o) {
        if (!(o instanceof DefaultFieldValueSpec)) return false;
        return checkDefaultFieldSpec((DefaultFieldValueSpec) o);
    }

    private boolean checkDefaultFieldSpec(DefaultFieldValueSpec spec) {
        if (!spec.name.equals(name)) return false;
        if (spec.value.getClass().isArray()) return arraysEquals(spec);
        return spec.value.equals(value);
    }

    private boolean arraysEquals(DefaultFieldValueSpec spec) {
        if (Array.getLength(spec.value) != Array.getLength(value)) return false;
        for (int i = 0; i < Array.getLength(spec.value); i++) {
            if (memberArraysUnequal(spec, i)) return false;
        }
        return true;
    }

    private boolean memberArraysUnequal(DefaultFieldValueSpec spec, int i) {
        Object o1 = Array.get(spec.value, i);
        Object o2 = Array.get(value, i);
        return !o1.equals(o2);
    }

    public int hashCode() {
        return 42;
    }

    // FIXME: SC509 Delegate to IndentingStringMaster.
    public String toString() {
        return "DefaultFieldValueSpec[name=" + name + ",value=" + value + "]";
    }

    private void validate() {
        validate(name);
        validate(value);
    }

    // FIXME: SC509 ? Null checker.
    private void validate(Object value) {
        NullMaster master = new NullMaster();
        master.check(value, name);
    }
}
