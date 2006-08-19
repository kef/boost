package au.net.netstorm.boost.test.atom;

import junit.framework.Assert;

import java.util.HashMap;
import java.util.Map;

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
        if (!isPrimitive(primitive)) fail(primitive + " is not a primitive type");
        return get(primitive);
    }

    public boolean isPrimitive(Class candidate) {
        return get(candidate) != null;
    }

    private Class get(Class primitive) {
        return (Class) map.get(primitive);
    }

    private void fail(String msg) {
        Assert.fail(msg);
    }
}
