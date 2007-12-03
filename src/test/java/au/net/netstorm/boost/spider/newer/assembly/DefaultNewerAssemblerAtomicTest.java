package au.net.netstorm.boost.spider.newer.assembly;

import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.HasFixtures;
import au.net.netstorm.boost.test.marker.LazyFields;
import au.net.netstorm.boost.util.type.DefaultInterface;

public final class DefaultNewerAssemblerAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    NewerAssembler subject;
    ProviderEngine provider;

    public void testAssemble() {
        Object result = subject.assemble(new DefaultInterface(NewDefaultTestDummy.class), provider);
        assertEquals(true, result instanceof NewDefaultTestDummy);
    }

    public void testAssembleFailsForNonNewers() {
        try {
            subject.assemble(new DefaultInterface(CharSequence.class), provider);
            fail();
        } catch (EdgeException result) {
            String expectedMessage = "There is no such field called \"CLASS_TO_NU\" in class java.lang.CharSequence";
            String actualMessage = result.getMessage();
            assertEquals(expectedMessage, actualMessage);
        }
    }

    public void setUpFixtures() {
        subject = new DefaultNewerAssembler();
    }
}
