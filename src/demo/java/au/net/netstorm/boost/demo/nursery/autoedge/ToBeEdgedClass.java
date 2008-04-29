package au.net.netstorm.boost.demo.nursery.autoedge;

public final class ToBeEdgedClass {
    private String message;

    public ToBeEdgedClass() throws Exception {
        throw new Exception();
    }

    public ToBeEdgedClass(String message) {
        this.message = message;
    }

    public String edgeMethod()  {
        return message;
    }
}
