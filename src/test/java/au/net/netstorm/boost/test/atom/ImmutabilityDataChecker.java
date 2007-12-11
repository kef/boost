package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.reflect.ClassMaster;
import au.net.netstorm.boost.reflect.DefaultClassMaster;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import junit.framework.Assert;

final class ImmutabilityDataChecker implements DataChecker {
    private ImmutableDeterminer immutableDeterminer = new DefaultImmutableDeterminer();
    private ClassMaster clsMaster = new DefaultClassMaster();

    public void check(Class cls, FieldSpec[] fields) {
        for (FieldSpec field : fields) {
            checkImmutable(field);
        }
    }

    private void checkImmutable(FieldSpec field) {
        Class type = field.getType();
        if (isImmutable(type)) return;
        if (isArrayContainingImmutables(type)) return;
        fail(type);
    }

    private boolean isImmutable(Class type) {
        return immutableDeterminer.isImmutable(type);
    }

    private boolean isArrayContainingImmutables(Class type) {
        if (!type.isArray()) return false;
        Class componentType = type.getComponentType();
        return isImmutable(componentType);
    }

    private void fail(Class type) {
        String rootType = getRootType(type);
        if (type.isArray()) fail(rootType + "(array of arrays)");
        fail(rootType);
    }

    private String getRootType(Class type) {
        if (!type.isArray()) return clsMaster.getShortName(type);
        Class componentType = type.getComponentType();
        return getRootType(componentType);
    }

    private void fail(String type) {
        Assert.fail(type + " " + "is not immutable.  All properties must be immutable.  This means they either " +
                "implement Immutable/Data or are known immutable types.");
    }
}
