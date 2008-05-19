package au.net.netstorm.boost.nursery.eight.legged.spider.provider;

// FIX 2328 provides an instance for an injection (may itself construct injections)
public interface Provider {
    Object nu();
}
