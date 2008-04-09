package au.net.netstorm.boost.gunge.array;

import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.gunge.nullo.DefaultNullMaster;
import au.net.netstorm.boost.gunge.nullo.NullMaster;

public final class DefaultArrayFlattener extends Primordial implements ArrayFlattener {
    private static final NullMaster NULL_MASTER = new DefaultNullMaster();
    private static final ArrayMaster ARRAY_MASTER = new DefaultArrayMaster();

    // Note. Cannot use check(Object[]) as it uses this method, hence stack overflow, so doesn't check embedded nulls.
    public Object[] flatten(Object[] unflattened) {
        NULL_MASTER.check(unflattened, "unflattened");
        List flattened = doFlatten(unflattened);
        return ARRAY_MASTER.toArray(flattened);
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
