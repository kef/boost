package au.net.netstorm.boost.primordial;

import au.net.netstorm.boost.util.equals.EqualsMaster;
import au.net.netstorm.boost.util.equals.FieldBasedEqualsMaster;
import au.net.netstorm.boost.util.tostring.IndentingToStringMaster;
import au.net.netstorm.boost.util.tostring.ToStringMaster;

public class Primordial {
    private EqualsMaster equalsMaster = new FieldBasedEqualsMaster();
    private ToStringMaster toStringMaster = new IndentingToStringMaster();

    // FIXME: SC509 Make final
    // FIXME: SC509 ? Provide PartialPrimordial.
    public int hashCode() {
        return 42;
    }

    public final boolean equals(Object obj) {
        return equalsMaster.equals(this, obj);
    }

    // FIXME: SC502 Should this really be final?  There are a number of cases in the codebase where overriding this
    // makes sense.
    public final String toString() {
        return toStringMaster.getString(this);
    }
}
