package au.net.netstorm.boost.spider.layer;

import java.lang.reflect.InvocationHandler;

public interface PassThroughInvocationHandler extends InvocationHandler {
    void setDelegate(Object delegate);
}
