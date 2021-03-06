package au.net.netstorm.boost.sniper.core;

public abstract class CleanTestCase extends BoooostCase implements Test {
    public abstract void runBare() throws Throwable;

    public final void runTest() throws Throwable {
        super.runTest();
    }

    protected final void setUp() throws Exception {
        boom();
    }

    protected final void tearDown() throws Exception {
        boom();
    }

    protected final void gearup() {
        boom();
    }

    protected final void geardown() {
        boom();
    }

    private void boom() {
        throw new UnsupportedOperationException("Use lifecycle provided by marker interfaces.");
    }
}
