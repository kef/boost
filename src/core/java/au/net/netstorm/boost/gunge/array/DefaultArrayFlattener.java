package au.net.netstorm.boost.gunge.array;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.gunge.nullo.DefaultNullMaster;
import au.net.netstorm.boost.gunge.nullo.NullMaster;

import java.util.ArrayList;
import java.util.List;

public final class DefaultArrayFlattener extends Primordial implements ArrayFlattener {
    private static final NullMaster NULL_MASTER = new DefaultNullMaster();
    private static final ArrayMaster ARRAY_MASTER = new DefaultArrayMaster();

    public Object[] flatten(Object[] unflattened) {
        NULL_MASTER.check(unflattened);
        List flattened = doFlatten(unflattened);
        return ARRAY_MASTER.toArray(flattened);
    }

    private List doFlatten(Object[] unflattened) {
        List flattened = new ArrayList();
        for (Object item : unflattened) processFlattened(flattened, item);
        return flattened;
    }

    private void processFlattened(List flattened, Object item) {
        if (item instanceof Object[]) {
            List children = doFlatten((Object[]) item);
            flattened.addAll(children);
        } else {
            flattened.add(item);
        }
    }
}
