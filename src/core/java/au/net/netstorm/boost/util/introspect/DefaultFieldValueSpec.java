package au.net.netstorm.boost.util.introspect;

import java.lang.reflect.Array;
import au.net.netstorm.boost.util.nullo.DefaultNullMaster;
import au.net.netstorm.boost.util.nullo.NullMaster;
import au.net.netstorm.boost.util.type.Immutable;

// FIX SC502 Who uses this. Do we need it? TJA: It's the best thing since sliced bread. Who'd want to remove it???
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

    public boolean equals(Object o) {
        if (!(o instanceof DefaultFieldValueSpec)) return false;
        return checkDefaultFieldSpec((DefaultFieldValueSpec) o);
    }

    private boolean checkDefaultFieldSpec(FieldValueSpec spec) {
        if (!spec.getName().equals(name)) return false;
        return checkValue(spec);
    }

    private boolean checkValue(FieldValueSpec spec) {
        if (spec.getValue() == null) return spec.getValue() == value;
        if (spec.getValue().getClass().isArray()) return arraysEquals(spec);
        return spec.getValue().equals(value);
    }

    // FIX SC509 TEST DRIVE THIS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
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
