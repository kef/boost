package au.net.netstorm.boost.demo.nursery.autoedge;

public class ToBeEdgedObject {
    private String state = "ok";
    public String getState() {
        return state;
    }
    public void setState(String state) throws Exception {
        if ("bad".equals(state)) throw new Exception();
        this.state = state;
    }
}
