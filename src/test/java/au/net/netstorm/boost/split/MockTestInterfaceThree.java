package au.net.netstorm.boost.split;

public final class MockTestInterfaceThree implements TestInterfaceThree {
    private CloneNotSupportedException ex;

    public void barf() throws CloneNotSupportedException {
        throw ex;
    }

    public void init(CloneNotSupportedException ex) {
        this.ex = ex;
    }
}
