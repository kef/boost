package au.net.netstorm.boost.bullet.splitter;

public final class MockTestInterfaceThree implements TestInterfaceThree {
    private RuntimeException ex;

    public void barf() {
        throw ex;
    }

    public void init(RuntimeException ex) {
        this.ex = ex;
    }
}
