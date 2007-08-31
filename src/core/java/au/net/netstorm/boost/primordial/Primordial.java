package au.net.netstorm.boost.primordial;

import au.net.netstorm.boost.util.equals.EqualsMaster;
import au.net.netstorm.boost.util.equals.FieldBasedEqualsMaster;
import au.net.netstorm.boost.util.tostring.IndentingToStringMaster;
import au.net.netstorm.boost.util.tostring.ToStringMaster;

public class Primordial {
    private static EqualsMaster equalsMaster = new FieldBasedEqualsMaster();
    private static ToStringMaster toStringMaster = new IndentingToStringMaster();

    public int hashCode() {
        return 42;
    }

    public boolean equals(Object obj) {
        return equalsMaster.equals(this, obj);
    }

    public String toString() {
        return toStringMaster.getString(this);
    }
}
