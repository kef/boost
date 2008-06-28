package au.net.netstorm.boost.nursery.eight.legged.spider.core;

public final class DefaultCyclic implements Cyclic {
    BackReference link;

    public BackReference get() {
        return link;
    }
}
