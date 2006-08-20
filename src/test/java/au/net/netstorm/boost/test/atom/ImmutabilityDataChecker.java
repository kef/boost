package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.reflect.ClassMaster;
import au.net.netstorm.boost.reflect.DefaultClassMaster;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import junit.framework.Assert;

final class ImmutabilityDataChecker implements DataChecker {
    private ImmutableDeterminer immutableDeterminer = new DefaultImmutableDeterminer();
    private ClassMaster clsMaster = new DefaultClassMaster();

    public void check(Class cls, FieldSpec[] fields) {
        for (int i = 0; i < fields.length; i++) {
            FieldSpec field = fields[i];
            checkImmutable(field);
        }
    }

    private void checkImmutable(FieldSpec field) {
        Class type = field.getType();
        if (immutableDeterminer.isImmutable(type)) return;
        fail(type, "is not immutable.  All properties must be immutable.  This means they either implement Immutable/Data or are known immutable types.");
    }

    private void fail(Class type, String msg) {
        String shortName = clsMaster.getShortName(type);
        Assert.fail(shortName + " " + msg);
    }
}
