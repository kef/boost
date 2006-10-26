package au.net.netstorm.boost.nursery.automock;

public interface MockExpectations {
    void call(Object ref, String method, Object returnValue, Object param0);
    // FIX SC525 Delete or incorporate.
//    void call(Object ref, String method, Object returnValue, Object param0, Object param1);
//    void call(Object ref, String method, Object returnValue, Object param0, Object param1, Object param2);
}
