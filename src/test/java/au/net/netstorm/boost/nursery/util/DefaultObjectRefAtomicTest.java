package au.net.netstorm.boost.nursery.util;

import au.net.netstorm.boost.gunge.core.LifecycleTestCase;
import au.net.netstorm.boost.gunge.marker.LazyFields;

public final class DefaultObjectRefAtomicTest extends LifecycleTestCase implements LazyFields {
    Object obj;

    public void testNull() {
        ObjectRef ref = initAndCheckExists(null, false);
        try {
            ref.get();
            fail();
        } catch (IllegalArgumentException e) { }
    }

    public void testNotNull() {
        ObjectRef ref = initAndCheckExists(obj, true);
        Object actual = ref.get();
        assertEquals(obj, actual);
    }

    private ObjectRef initAndCheckExists(Object anObj, boolean shouldExist) {
        ObjectRef ref = new DefaultObjectRef(anObj);
        boolean exists = ref.exists();
        assertEquals(shouldExist, exists);
        return ref;
    }
}
