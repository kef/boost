package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.util.nullo.DefaultNullMaster;
import au.net.netstorm.boost.util.nullo.NullMaster;
import au.net.netstorm.boost.util.type.Immutable;

import java.lang.reflect.Array;

// FIX SC502 Who uses this.  Do we need it?
// FIX SC506 Can just be an immutable.
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

    // FIX SC509 TEST DRIVE THIS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public boolean equals(Object o) {
        if (!(o instanceof DefaultFieldValueSpec)) return false;
        return checkDefaultFieldSpec((DefaultFieldValueSpec) o);
    }

    private boolean checkDefaultFieldSpec(FieldValueSpec spec) {
        if (!spec.getName().equals(name)) return false;
        if (spec.getValue().getClass().isArray()) return arraysEquals(spec);
        return spec.getValue().equals(value);
    }

    private boolean arraysEquals(FieldValueSpec spec) {
        if (Array.getLength(spec.getValue()) != Array.getLength(value)) return false;
        for (int i = 0; i < Array.getLength(spec.getValue()); i++) {
            if (memberArraysUnequal(spec, i)) return false;
        }
        return true;
    }

    private boolean memberArraysUnequal(FieldValueSpec spec, int i) {
        Object o1 = Array.get(spec.getValue(), i);
        Object o2 = Array.get(value, i);
        return !o1.equals(o2);
    }

    public int hashCode() {
        return 42;
    }

    // FIX SC509 Delegate to IndentingStringMaster.
    public String toString() {
        return "DefaultFieldValueSpec[name=" + name + ",value=" + value + "]";
    }

    private void validate() {
        validate(name);
    }

    // FIX SC509 ? Null checker.
    private void validate(Object value) {
        NullMaster master = new DefaultNullMaster();
        master.check(value, name);
    }
}
