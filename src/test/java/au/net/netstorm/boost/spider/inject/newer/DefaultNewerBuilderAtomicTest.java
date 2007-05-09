package au.net.netstorm.boost.spider.inject.newer;

import au.net.netstorm.boost.test.cases.BoooostCase;
import au.net.netstorm.boost.util.type.DefaultInterface;

public final class DefaultNewerBuilderAtomicTest extends BoooostCase {
    NewerAssembler subject = new DefaultNewerAssembler();

    public void testBuild() {
        Object result = subject.assemble(new DefaultInterface(NewDefaultTestDummy.class));
        assertEquals(true, result instanceof NewDefaultTestDummy);
    }
}
