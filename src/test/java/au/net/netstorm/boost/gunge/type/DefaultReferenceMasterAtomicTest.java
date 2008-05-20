package au.net.netstorm.boost.gunge.type;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultReferenceMasterAtomicTest extends LifecycleTestCase implements InjectableTest, LazyFields {
    ReferenceMaster subject;
    Reference ref1Mock;
    Reference ref2Mock;
    
    public void testResolve() {
        expect.oneCall(ref1Mock, "ref1", "getRef");
        expect.oneCall(ref2Mock, "ref2", "getRef");
        Reference[] refs = {ref1Mock, ref2Mock};
        Object[] expected = {"ref1", "ref2"};
        checkResolve(expected, refs);
    }

    private void checkResolve(Object[] expected, Reference[] refs) {
        Object[] result = subject.resolve(refs);
        assertEquals(expected, result);
    }
}
