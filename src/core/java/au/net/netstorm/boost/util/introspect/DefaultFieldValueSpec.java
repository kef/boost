package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.util.equals.ArraysEqualsMaster;
import au.net.netstorm.boost.util.equals.DefaultArraysEqualsMaster;
import au.net.netstorm.boost.util.nullo.DefaultNullMaster;
import au.net.netstorm.boost.util.nullo.NullMaster;
import au.net.netstorm.boost.util.type.Immutable;

// FIX SC502 Who uses this. Do we need it? TJA: It's the best thing since sliced bread. Who'd want to remove it???

// FIX SC506 Can just be an immutable.
public final class DefaultFieldValueSpec implements Immutable, FieldValueSpec {
    private static ArraysEqualsMaster arraysEquals = new DefaultArraysEqualsMaster();
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
        if (!o.getClass().equals(DefaultFieldValueSpec.class)) return false;
        return checkDefaultFieldSpec((FieldValueSpec) o);
    }

    private boolean checkDefaultFieldSpec(FieldValueSpec spec) {
        if (!spec.getName().equals(name)) return false;
        return checkValue(spec);
    }

    private boolean checkValue(FieldValueSpec spec) {
        Object otherValue = spec.getValue();
        if (otherValue == null) return otherValue == value;
        if (otherValue.getClass().isArray()) return arraysEquals.equals(otherValue, value);
        return otherValue.equals(value);
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
