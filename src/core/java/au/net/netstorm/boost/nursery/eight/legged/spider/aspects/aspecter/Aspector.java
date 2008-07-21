package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.aspecter;

// FIX 2394 use or lose. expose like binder.
public interface Aspector {
    // FIX 2394 Strong type engine. Make this a Nice api.
    AspectTarget cut(Class iface);
    AspectTarget cut(Class iface, String method);
}
