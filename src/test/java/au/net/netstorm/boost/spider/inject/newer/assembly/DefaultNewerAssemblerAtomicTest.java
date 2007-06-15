package au.net.netstorm.boost.spider.inject.newer.assembly;

import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.DefaultInterface;

public final class DefaultNewerAssemblerAtomicTest extends InteractionTestCase implements HasFixtures {
    NewerAssembler subject;
    ProviderEngine provider;

    public void testAssemble() {
        Object result = subject.assemble(new DefaultInterface(NewDefaultTestDummy.class));
        assertEquals(true, result instanceof NewDefaultTestDummy);
    }

    public void testAssembleFailsForNonNewers() {
        try {
            subject.assemble(new DefaultInterface(CharSequence.class));
            fail();
        } catch (EdgeException result) {
            String expectedMessage = "There is no such field called \"CLASS_TO_NU\" in class java.lang.CharSequence";
            String actualMessage = result.getMessage();
            assertEquals(expectedMessage, actualMessage);
        }
    }

    public void setUpFixtures() {
        subject = new DefaultNewerAssembler(provider);
    }
}
