package au.net.netstorm.boost.nursery.reflect.checker;

import au.net.netstorm.boost.test.automock.BoooostTestCase;
import au.net.netstorm.boost.test.reflect.checker.DefaultModifierTestChecker;
import au.net.netstorm.boost.test.reflect.checker.ModifierTestChecker;

public final class BlockAtomicTest extends BoooostTestCase {
    private final ModifierTestChecker modifierChecker = new DefaultModifierTestChecker();

    public void testProperties() {
        modifierChecker.checkPublic(Block.class);
    }
}
