package au.net.netstorm.boost.util.type;

import java.util.Map;
import java.util.Set;
import au.net.netstorm.boost.nursery.util.type.DefaultInterface;
import au.net.netstorm.boost.sniper.core.BoooostCase;

public final class DefaultInterfaceUtilAtomicTest extends BoooostCase {
    private final InterfaceUtil subject = new DefaultInterfaceUtil();
    private static final Interface MAP = new DefaultInterface(Map.class);
    private static final Interface SET = new DefaultInterface(Set.class);
    private static final Class[] ZERO_CLASSES = {};
    private static final Interface[] ZERO_INTERFACES = {};
    private static final Class[] MULTIPLE_CLASSES = {Map.class, Map.class, Set.class};
    private static final Interface[] MULTIPLE_INTERFACES = {MAP, MAP, SET};

    public void testZero() {
        Interface[] result = subject.interfaces(ZERO_CLASSES);
        assertEquals(ZERO_INTERFACES, result);
    }

    public void testMultiple() {
        Interface[] result = subject.interfaces(MULTIPLE_CLASSES);
        assertEquals(MULTIPLE_INTERFACES, result);
    }
}
