package au.net.netstorm.boost.retire.reflect;

import au.net.netstorm.boost.test.cases.BoooostCase;
import au.net.netstorm.boost.test.reflect.checker.DefaultModifierTestChecker;
import au.net.netstorm.boost.test.reflect.checker.ModifierTestChecker;

public final class BlockAtomicTest extends BoooostCase {
    private final ModifierTestChecker modifierChecker = new DefaultModifierTestChecker();

    public void testProperties() {
        modifierChecker.checkPublic(Block.class);
    }
}