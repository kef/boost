package au.net.netstorm.boost.primordial;

import au.net.netstorm.boost.util.equals.EqualsMaster;
import au.net.netstorm.boost.util.equals.FieldBasedEqualsMaster;
import au.net.netstorm.boost.util.tostring.IndentingToStringMaster;
import au.net.netstorm.boost.util.tostring.ToStringMaster;

public class Primordial {
    private EqualsMaster equalsMaster = new FieldBasedEqualsMaster();
    private ToStringMaster toStringMaster = new IndentingToStringMaster();

    // FIXME: SC501 Make final and provide PartialPrimordial.
    public int hashCode() {
        return 42;
    }

    public final boolean equals(Object obj) {
        return equalsMaster.equals(this, obj);
    }

    public final String toString() {
        return toStringMaster.getString(this);
    }
}
