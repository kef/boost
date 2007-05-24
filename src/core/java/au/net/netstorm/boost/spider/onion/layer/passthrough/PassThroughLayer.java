package au.net.netstorm.boost.spider.onion.layer.passthrough;

import java.lang.reflect.InvocationHandler;

public interface PassThroughLayer extends InvocationHandler {
    void setDelegate(Object delegate);
}
