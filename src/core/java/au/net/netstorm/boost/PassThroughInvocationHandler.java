package au.net.netstorm.boost;

import java.lang.reflect.InvocationHandler;

public interface PassThroughInvocationHandler extends InvocationHandler {
    void setDelegate(Object delegate);
}
