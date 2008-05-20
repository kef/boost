package au.net.netstorm.boost.spider.inject.resolver.field;

import java.lang.reflect.Field;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;

public final class DefaultResolvableFieldMasterAtomicTest extends LifecycleTestCase implements InjectableTest {
    private Legend legend = new Legend();
    ResolvableFieldMaster resolvable;
    EdgeClass classer;


    public void testIsResolvable() {
        checkIsResolvable(true, "resolveMe");
        checkIsResolvable(true, "resolveMeToo");
    }


    public void testIsNotResolvable() {
        checkIsResolvable(false, "doNotResolveMe");
        checkIsResolvable(false, "doNotResolveMeEither");
        checkIsResolvable(false, "doNotResolveMeIAmPrivate");
        checkIsResolvable(false, "doNotResolveStaticOrSynthetic");
    }

    private void checkIsResolvable(boolean expected, String name) {
        Field f = classer.getDeclaredField(Legend.class,  name);
        boolean result = resolvable.isResolvableField(legend, f);
        assertEquals(expected, result);
    }
}
