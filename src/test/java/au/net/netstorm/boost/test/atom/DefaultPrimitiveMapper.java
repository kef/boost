package au.net.netstorm.boost.test.atom;

import junit.framework.Assert;

import java.util.HashMap;
import java.util.Map;

// FIX SC600 Stitch this into Triangulator.
// FIX SC600 Add method to query whether we are dealing with a primitive.
final class DefaultPrimitiveMapper implements PrimitiveMapper {
    private final Map map = new HashMap();

    {
        map.put(boolean.class, Boolean.class);
        map.put(char.class, Character.class);
        map.put(int.class, Integer.class);
        map.put(long.class, Long.class);
        map.put(float.class, Float.class);
        map.put(double.class, Double.class);
    }

    public Class getWrapped(Class primitive) {
        Class mapped = (Class) map.get(primitive);
        if (mapped == null) fail(primitive + " is not a primitive type");
        return mapped;
    }

    private void fail(String msg) {
        Assert.fail(msg);
    }
}
