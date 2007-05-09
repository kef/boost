package au.net.netstorm.boost.spider.inject.newer;

import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.test.cases.BoooostCase;
import au.net.netstorm.boost.util.type.DefaultInterface;

public final class DefaultNewerBuilderAtomicTest extends BoooostCase {
    NewerAssembler subject = new DefaultNewerAssembler();

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
}
