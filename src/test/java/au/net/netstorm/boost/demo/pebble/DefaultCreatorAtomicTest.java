package au.net.netstorm.boost.demo.pebble;

import java.util.HashSet;
import junit.framework.TestCase;

public final class DefaultCreatorAtomicTest extends TestCase {

    public void testCreator() {
        Class type = HashSet.class;
        Creator creator = new DefaultCreator(type);
    }
}
