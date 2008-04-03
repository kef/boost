package au.net.netstorm.boost.gunge.atom;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public final class DefaultPrimitiveBoxer implements PrimitiveBoxer {
    private final Map map = new HashMap();

    {
        map.put(boolean.class, Boolean.class);
        map.put(int.class, Integer.class);
        map.put(long.class, Long.class);
        map.put(float.class, Float.class);
        map.put(double.class, Double.class);
        map.put(byte.class, Byte.class);
        map.put(char.class, Character.class);
    }

    public Class getBoxed(Class primitive) {
        if (!isPrimitive(primitive)) {
            fail(primitive + " is not a primitive type");
        }
        return get(primitive);
    }

    public boolean isPrimitive(Class candidate) {
        return candidate.isPrimitive();
    }

    public boolean isBoxed(Class candidate) {
        Collection values = map.values();
        return values.contains(candidate);
    }

    private Class get(Class primitive) {
        return (Class) map.get(primitive);
    }

    private void fail(String msg) {
        Assert.fail(msg);
    }
}
