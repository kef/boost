package au.net.netstorm.boost.nursery.eight.legged.spider.provider.core;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.gunge.type.ResolvedInstance;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.UnresolvedInstance;
import au.net.netstorm.boost.gunge.type.ReferenceMaster;
import au.net.netstorm.boost.spider.instantiate.Instantiator;

public final class MultiProviderAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private Provider subject;
    FieldTestUtil fielder;
    ResolvedInstance resolvedMock;
    UnresolvedInstance unresolvedMock;
    Implementation implMock;
    ReferenceMaster referencesMock;
    Instantiator instantiatorMock;

    public void setUpFixtures() {
        subject = new MultiProvider(implMock);
        fielder.setInstance(subject, "references", referencesMock);
        fielder.setInstance(subject, "instantiator", instantiatorMock);
    }
    
    public void testNew() {
        checkNu("any");
        checkNu("any"); // must instantiate each time
    }

    private void checkNu(String s) {
        Object[] resolved = {s};
        expect.oneCall(referencesMock, resolved, "resolve", varargs(resolvedMock));
        expect.oneCall(instantiatorMock, unresolvedMock, "instantiate", implMock, varargs(s));
        UnresolvedInstance result = subject.nu(resolvedMock);
        assertSame(result, unresolvedMock);
    }

    // FIX 2328 this is nasty, maybe something like this could be incorporated into expectations to make in un-nasty
    private Object varargs(Object o) {
        return new Object[]{o};
    }
}
