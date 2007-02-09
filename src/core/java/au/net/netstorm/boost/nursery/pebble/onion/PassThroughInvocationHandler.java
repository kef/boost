package au.net.netstorm.boost.nursery.pebble.onion;

import java.lang.reflect.InvocationHandler;

public interface PassThroughInvocationHandler extends InvocationHandler {
    void setDelegate(Object delegate);
}
