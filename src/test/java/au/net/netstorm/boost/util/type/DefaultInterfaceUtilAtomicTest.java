package au.net.netstorm.boost.util.type;

import au.net.netstorm.boost.test.cases.BoooostCase;

public final class DefaultInterfaceUtilAtomicTest extends BoooostCase {
    private final InterfaceUtil subject = new DefaultInterfaceUtil();

    public void testZero() {
        subject.interfaces(new Class[]{});
    }
}
