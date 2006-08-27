package au.net.netstorm.boost.util.array;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.nullo.DefaultNullMaster;
import au.net.netstorm.boost.util.nullo.NullMaster;

import java.util.ArrayList;
import java.util.List;

public final class DefaultArrayFlattener extends Primordial implements ArrayFlattener {
    private static final NullMaster NULL_MASTER = new DefaultNullMaster();

    // Note. Cannot use check(Object[]) as it uses this method, hence stack overflow, so doesn't check embedded nulls.
    public Object[] flatten(Object[] unflattened) {
        NULL_MASTER.check(unflattened, "unflattened");
        List flattened = doFlatten(unflattened);
        return flattened.toArray(new Object[flattened.size()]);
    }

    private List doFlatten(Object[] unflattened) {
        List flattened = new ArrayList();
        for (int i = 0; i < unflattened.length; i++) {
            Object item = unflattened[i];
            if (item instanceof Object[]) {
                flattened.addAll(doFlatten((Object[]) item));
            } else {
                flattened.add(item);
            }
        }
        return flattened;
    }
}
