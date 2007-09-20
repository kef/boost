package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.util.type.Implementation;

public final class DefaultLog implements Log, ContextAware {
    private Class context;
    LogUtil logUtil;

    public void setContext(Implementation impl) {
        context = impl.getImpl();
    }

    public void info(String s) {
        logUtil.info(context, s);
    }
}
