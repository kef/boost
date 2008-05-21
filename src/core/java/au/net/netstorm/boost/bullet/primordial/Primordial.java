package au.net.netstorm.boost.bullet.primordial;

import au.net.netstorm.boost.gunge.equals.EqualsMaster;
import au.net.netstorm.boost.gunge.tostring.ToStringMaster;
import au.net.netstorm.boost.nursery.gunge.equals.FieldBasedEqualsMaster;
import au.net.netstorm.boost.nursery.gunge.tostring.IndentingToStringMaster;

public class Primordial {
    private static EqualsMaster equalsMaster = new FieldBasedEqualsMaster();
    private static ToStringMaster toStringMaster = new IndentingToStringMaster();

    // SUGGEST: Equals is based on fields.  Why isn't hashCode.
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
