package au.net.netstorm.boost.test.checker;

import au.net.netstorm.boost.test.primordial.PrimordialTestCase;

// FIXME: SC523 Is this too much for an interface? Maybe just a test that it's an interface & public.
public final class BlockAtomicTest extends PrimordialTestCase {
    private static final ModifierTestChecker MODIFIER_CHECKER = new DefaultModifierTestChecker();
    private static final AssertException ASSERT_EXCEPTION = new DefaultAssertException();

    public void testProperties() {
        MODIFIER_CHECKER.checkPublic(Block.class);
    }

    public void testExecuteThrowsException() {
        checkExceptionOne();
        checkExceptionTwo();
    }

    private void checkExceptionTwo() {
        Block block = new Block() {
            public void execute() {
                throw new UnsupportedOperationException();
            }
        };
        expectFailure(UnsupportedOperationException.class, block);
    }

    private void checkExceptionOne() {
        Block block = new Block() {
            public void execute() {
                throw new IllegalArgumentException();
            }
        };
        expectFailure(IllegalArgumentException.class, block);
    }

    private void expectFailure(Class expectedException, Block toExecute) {
        try {
            toExecute.execute();
            fail();
        } catch (Throwable expected) {
            ASSERT_EXCEPTION.checkExceptionClass(expectedException, expected);
        }
    }
}
